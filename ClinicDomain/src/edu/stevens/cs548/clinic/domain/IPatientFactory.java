package edu.stevens.cs548.clinic.domain;

import java.util.Date;

public interface IPatientFactory {
	
	public Patient createPatient(long pid, String name, Date dob);
	
}
