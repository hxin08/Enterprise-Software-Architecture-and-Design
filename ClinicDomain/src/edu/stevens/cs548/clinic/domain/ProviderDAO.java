package edu.stevens.cs548.clinic.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

public class ProviderDAO implements IProviderDAO {
	
	@PersistenceContext
	private EntityManager em;
	private TreatmentDAO treatmentDAO;

	@Override
	public Provider getProviderByDbId(long id) throws ProviderExn {
		// TODO Auto-generated method stub
		Provider p = em.find(Provider.class,id);
		if (p == null){
			throw new ProviderExn("Provider not found:primary key = " +id);
		}else {
			p.setTreatmentDAO(this.treatmentDAO);
			return p;
		}
	}

	@Override
	public Provider getProviderByNPI(long pid) throws ProviderExn {
		TypedQuery<Provider> query = 
				em.createNamedQuery("SearchProviderByNameDOB",Provider.class)
				.setParameter("pid",pid);
		List<Provider> providers = query.getResultList();
		if(providers.size() > 1)
			throw new ProviderExn("Duplicate provider records: provider id = " + pid);
		else if (providers.size() <1)
			throw new ProviderExn("Provider not found: provider id = " +pid);
		else {
			Provider p = providers.get(0);
			p.setTreatmentDAO(this.treatmentDAO);
			return p;
		}
	}

	@Override
	public List<Provider> getProviderByNameDob(String name, Date dob) {
		TypedQuery<Provider> query = em.createNamedQuery("SearchProviderByNameDOB",Provider.class)
									.setParameter("name",name)
									.setParameter("dob",dob);
		List<Provider> providers = query.getResultList();
		for(Provider p :providers){
			p.setTreatmentDAO(this.treatmentDAO);
		}
		return providers;
	}
	
	@Override
	public void addProvider(Provider provider) throws ProviderExn {
		long pid =provider.getNPI();
		TypedQuery<Provider> query = 
				em.createNamedQuery("SearchProviderByNameDOB",Provider.class)
				.setParameter("pid",pid);
		List<Provider> providers = query.getResultList();
	    if (providers.size() <1){
			em.persist(provider);
			provider.setTreatmentDAO(this.treatmentDAO);
	    } else {
			Provider provider2 = providers.get(0);
			throw new ProviderExn("Insertion: Provider with provider id (" +pid
					+ ") already exists.\n** Name:"+provider2.getName());
	    }
	}

	@Override
	public void deleteProvider(Provider provider) throws ProviderExn {
		//		em.createQuery("delete from Treatment t where t.provider.id =id")
		//			.setParameter("id",provider.getId())
		//			.executeUpdate();
		em.remove(provider);
	}
	public ProviderDAO (EntityManager em){
		this.em = em;
		this.treatmentDAO = new TreatmentDAO(em);
	}
}
