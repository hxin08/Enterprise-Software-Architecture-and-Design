package edu.stevens.cs548.clinic.service.ejb;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import edu.stevens.cs548.clinic.domain.IPatientDAO;
import edu.stevens.cs548.clinic.domain.IPatientDAO.PatientExn;
import edu.stevens.cs548.clinic.domain.IProviderDAO;
import edu.stevens.cs548.clinic.domain.IProviderDAO.ProviderExn;
import edu.stevens.cs548.clinic.domain.ITreatmentDAO.TreatmentExn;
import edu.stevens.cs548.clinic.domain.PatientDAO;
import edu.stevens.cs548.clinic.domain.Provider;
import edu.stevens.cs548.clinic.domain.ProviderDAO;
import edu.stevens.cs548.clinic.domain.ProviderFactory;
import edu.stevens.cs548.clinic.domain.Treatment;
import edu.stevens.cs548.clinic.service.dto.provider.ProviderDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.PatientService.TreatmentPDOtoDTO;
import edu.stevens.cs548.clinic.test.PersistenceContext;

/**
 * Session Bean implementation class PatientService
 */
@Stateless(name="ProviderServiceBean")
public class ProviderService implements IProviderServiceLocal, IProviderServiceRemote {

	private ProviderFactory providerFactory;
    
	private IProviderDAO providerDAO;
    
    private IPatientDAO patientDAO;
    
    public ProviderService() {	
    	providerFactory = new ProviderFactory();
    }
    
    @PersistenceContext(unitName="ClinicDomain")
    private EntityManager em;
    
    @PostConstruct
    private void initialize(){
    	patientDAO = new PatientDAO(em);
    	providerDAO = new ProviderDAO(em);
    }
	/**
     * @param dob 
	 * @see IProviderService#getProviderByNameDob(String)
     */
    public ProviderDTO[] getProviderByName(String name, Date dob) {
    	List<Provider> providers = providerDAO.getProviderByNameDob(name, dob);
    	ProviderDTO[] dto = new ProviderDTO[providers.size()];
    	for(int i=0; i <dto.length; i++){
    		dto[i] = new ProviderDTO(providers.get(i));
    	}
			return dto;
    }

	/**
     * @param specialization 
	 * @param pid 
	 * @see IProviderService#createProvider(String, long)
     */
    public long createProvider(String name, String specialization, long pid) {
    	Provider provider = this.providerFactory.createProvider(pid, name, specialization);//.createProvider(name,NPI);
			try {
				providerDAO.addProvider(provider);
			} catch (ProviderExn e) {
				e.printStackTrace();
			}
    	return provider.getId();
    }

	/**
     * @throws ProviderServiceExn 
	 * @see IProviderService#getTreatments(long, long[], long)
     */
    public TreatmentDto[] getTreatments(long id, long[] tids, long NPI) throws ProviderServiceExn {
    	try{
			Provider provider = providerDAO.getProviderByNPI(id);
			TreatmentDto[] treatments = new TreatmentDto[tids.length];
			for (int i = 0; i < tids.length; i++){
				TreatmentPDOtoDTO visitor = new TreatmentPDOtoDTO();
				provider.visitTreatment(tids[i], visitor);
				treatments[i] = visitor.getDTO();
			}
			return treatments;
		} catch (ProviderExn e) {
			throw new ProviderNotFoundExn(e.toString());
		} catch (TreatmentExn e){
			throw new ProviderServiceExn(e.toString());
		}
    }

	/**
     * @throws ProviderExn 
	 * @see IProviderService#createTreatmentByIdNPI(long, long, TreatmentDto)
     */
    public long createTreatmentByIdNPI(long pid, long NPI, String tdo) throws PatientExn, ProviderExn{
    	
    	long patientId = this.patientDAO.getPatientByDbId(pid).getId();
    	long nPI = this.providerDAO.getProviderByNPI(NPI).getNPI();
		TypedQuery<Treatment> query = 
				em.createNamedQuery("SearchTreatmentByIdNPI",Treatment.class)
				.setParameter("pid",patientId)
				.setParameter("NPI",nPI);
		List<Treatment> treatments = query.getResultList();
	    if (treatments.size() <1){
			em.persist(treatments);
			((Treatment) treatments).setTreatmentType(tdo);
	    } 
	    return 0;
    }

	/**
     * @throws ProviderServiceExn 
	 * @throws PatientServiceExn 
	 * @see IProviderService#deleteProvider(String, long)
     */
    public long deleteProvider(String name, long id) throws ProviderServiceExn{
    	try{
    		Provider provider = providerDAO.getProviderByDbId(id);
    		if (!name.equals(provider.getName())){
    			throw new ProviderServiceExn("Tried to delete wrong provider: name = "+name+" , id = "+id);
    		} else {
    			providerDAO.deleteProvider(provider);
    		}
    	}catch (ProviderExn e){
    		throw new ProviderServiceExn(e.toString());
    	}
    	return 0;
    }

	/**
     * @throws ProviderServiceExn 
	 * @see IProviderService#getProviderByNPI(long)
     */
    public ProviderDTO getProviderByNPI(long NPI) throws ProviderServiceExn {
    	try{
			Provider provider = providerDAO.getProviderByDbId(NPI);
			return new ProviderDTO(provider);
		}catch (ProviderExn e) {
			throw new ProviderServiceExn(e.toString());
		}
    }
    
    @Resource(name="SiteInfo")
	private String siteInformation;
	
	@Override
	public String siteInfo() {
		return siteInformation;
	}
	
	@Override
	public TreatmentDto createTreatmentByIdNPI(long id, long NPI,
			TreatmentDto tdo) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public long createProvider(String name, long NPI) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public ProviderDTO[] getProviderByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}
}
