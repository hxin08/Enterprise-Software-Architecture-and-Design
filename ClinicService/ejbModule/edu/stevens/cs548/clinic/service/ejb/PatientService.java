package edu.stevens.cs548.clinic.service.ejb;

import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.core.UriInfo;
import edu.stevens.cs548.clinic.domain.IPatientDAO;
import edu.stevens.cs548.clinic.domain.IPatientDAO.PatientExn;
import edu.stevens.cs548.clinic.domain.ITreatmentDAO.TreatmentExn;
import edu.stevens.cs548.clinic.domain.ITreatmentVisitor;
import edu.stevens.cs548.clinic.domain.Patient;
import edu.stevens.cs548.clinic.domain.PatientDAO;
import edu.stevens.cs548.clinic.domain.PatientFactory;
import edu.stevens.cs548.clinic.service.dto.patient.PatientDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.DrugTreatmentType;
import edu.stevens.cs548.clinic.service.dto.treatment.RadiologyType;
import edu.stevens.cs548.clinic.service.dto.treatment.SurgeryType;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;

/**
 * Session Bean implementation class PatientService
 */
@Stateless(name="PatientServiceBean")
public class PatientService implements IPatientServiceLocal, IPatientServiceRemote {

    private PatientFactory patientFactory;
    
    private IPatientDAO patientDAO;    
    
    public PatientService() {
    	patientFactory = new PatientFactory();
    }
    
    @PersistenceContext(unitName="ClinicDomain")
    private EntityManager em;
    
    @PostConstruct
    private void initialize(){
    	patientDAO = new PatientDAO(em);
    }
	/**
     * @see IPatientService#getPatientsByNameDob(String, Date)
     */
    public PatientDTO[] getPatientsByNameDob(String name, Date dob) {
    	List<Patient> patients = patientDAO.getPatientByNameDob(name,dob);
    	PatientDTO[] dto = new PatientDTO[patients.size()];
    	for(int i=0; i <dto.length; i++){
    		dto[i] = new PatientDTO(patients.get(i));
    	}
		return dto;
    }
    
    @SuppressWarnings("unused")
	private PatientDTO patientToDTO(Patient patient){
    	return new PatientDTO(patient);
    }
	/**
     * @see IPatientService#getPatientByDbId(long)
     */
    public PatientDTO getPatientByDbId(long id) throws PatientServiceExn {
		try{
			Patient patient = patientDAO.getPatientByDbId(id);
			return new PatientDTO(patient);
		}catch (PatientExn e) {
			throw new PatientServiceExn(e.toString());
		}
    }
    /**
     * @see IPatientService#getPatientByPatId(long)
     */
    public PatientDTO getPatientByPatId(long pid) throws PatientServiceExn {
    	try{
    		Patient patient = patientDAO.getPatientByPatientId(pid);
    		return new PatientDTO(patient);
    	}catch (PatientExn e){
    		throw new PatientServiceExn(e.toString());
    	}
    }
	/**
     * @return 
	 * @see IPatientService#deletePatient(String, long)
     */
    public long deletePatient(String name, long id) throws PatientServiceExn {
    	try{
    		Patient patient = patientDAO.getPatientByDbId(id);
    		if (!name.equals(patient.getName())){
    			throw new PatientServiceExn("Tried to delete wrong patient: name = "+name+" , id = "+id);
    		} else {
    			patientDAO.deletePatient(patient);
    		}
    	}catch (PatientExn e){
    		throw new PatientServiceExn(e.toString());
    	}
    	return 0;
    }

	/**
	 * @see IPatientService#createPatient(String, Date, long)
     */
    public long createPatient(String name, Date dob, long patientId) throws PatientServiceExn {
    	Patient patient = this.patientFactory.createPatient(patientId, name, dob);
		try{
			patientDAO.addPatient(patient);
		} catch(PatientExn e) {
			throw new PatientServiceExn(e.toString());
		}
    	return patient.getId();
    }
    
	@Override
	public long addDrugTreatment(long id, String diagnosis, String drug,
			float dosage) throws PatientServiceExn {
		try{
			Patient patient = patientDAO.getPatientByDbId(id);
			patient.addDrugTreatment(diagnosis, drug, dosage);
		} catch (PatientExn e){
			throw new PatientNotFoundExn(e.toString());
		}
		return 0;//assignment
	}
	static class TreatmentPDOtoDTO implements ITreatmentVisitor {
		private TreatmentDto dto;
		public TreatmentDto getDTO() {
			return dto;
		}
		
		@Override
		public void visitDrugTreatment(long tid, String diagnosis, String drug,
				float dosage, String prescribingphysician) {
			dto = new TreatmentDto();
			dto.setDiagnosis(diagnosis);
			DrugTreatmentType drugInfo = new DrugTreatmentType();
			drugInfo.setDosage(dosage);
			drugInfo.setDrug(drug);
			drugInfo.setPrescribingphysician(prescribingphysician);
			dto.setDrugTreatment(drugInfo);
		}

		@Override
		public void visitRadiology(long tid, String diagnosis,
				String radiologist, List<Date> date) {
			dto = new TreatmentDto();
			dto.setDiagnosis(diagnosis);
			RadiologyType drugInfo = new RadiologyType();
			drugInfo.setRadiologist(radiologist);
			drugInfo.setDate(date);
			dto.setRadiology(drugInfo);
		}

		@Override
		public void visitSurgery(long tid, String diagnosis, String surgeon,
				Date surgeryDate) {
			dto = new TreatmentDto();
			dto.setDiagnosis(diagnosis);
			SurgeryType drugInfo = new SurgeryType();
			drugInfo.setSurgeon(surgeon);
			drugInfo.setDate(surgeryDate);
			dto.setSurgery(drugInfo);
		}			
	}
	
	public TreatmentDto[] getTreatments(long id, long[] tids)
			throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn {
		try{
			Patient patient = patientDAO.getPatientByDbId(id);
			TreatmentDto[] treatments = new TreatmentDto[tids.length];
			for (int i = 0; i < tids.length; i++){
				TreatmentPDOtoDTO visitor = new TreatmentPDOtoDTO();
				patient.visitTreatment(tids[i], visitor);
				treatments[i] = visitor.getDTO();
			}
			return treatments;
		} catch (PatientExn e) {
			throw new PatientNotFoundExn(e.toString());
		} catch (TreatmentExn e){
			throw new PatientServiceExn(e.toString());
		}
	}
	
	@Override
	public void deleteTreatment(long id, long tid) throws PatientNotFoundExn,
			TreatmentNotFoundExn, PatientServiceExn {
		try{
			Patient patient = patientDAO.getPatientByDbId(id);
			patient.deleteTreatment(tid);
		} catch (PatientExn e){
			throw new PatientNotFoundExn(e.toString());
		} catch (TreatmentExn e){
			throw new PatientServiceExn(e.toString());
		}	
	}
	
	@Resource(name="SiteInfo")
	private String siteInformation;
	
	@Override
	public String siteInfo() {
		return siteInformation;
	}
	@Override
	public List<TreatmentDto> getTreatments(long id, UriInfo context)
			throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn {
		// TODO Auto-generated method stub
		return null;
	}
}
