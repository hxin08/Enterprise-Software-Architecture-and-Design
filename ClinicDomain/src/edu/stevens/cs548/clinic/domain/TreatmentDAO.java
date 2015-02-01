package edu.stevens.cs548.clinic.domain;

import javax.persistence.EntityManager;

public class TreatmentDAO implements ITreatmentDAO {
	
	public TreatmentDAO (EntityManager em) {
		this.em =em;
	}
	private EntityManager em;

	@Override
	public Treatment getTreatmentByDbId(long id) throws TreatmentExn {
		Treatment t = em.find(Treatment.class,id);
		if(t == null){
			throw new TreatmentExn("Missing treatment: id = " + id );
		}else {
			return t;
		}
	}
	
	@Override
	public long addTreatment(Treatment t,Patient p){
		p.addTreatment(t);
		em.persist(t);
		return t.getId();
	}

	@Override
	public long addTreatment(Treatment t) {
		// TODO Auto-generated method stub
		em.persist(t);
		return t.getId();
	}
	
	@Override 
	public void deleteTreatment(Treatment t) {
		em.remove(t);
	}
}
