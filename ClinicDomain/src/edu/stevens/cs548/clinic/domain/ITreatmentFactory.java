package edu.stevens.cs548.clinic.domain;

public interface ITreatmentFactory {
	
	public Treatment createTreatment(long providerId, String diagnosis,String treatmentType);
}
