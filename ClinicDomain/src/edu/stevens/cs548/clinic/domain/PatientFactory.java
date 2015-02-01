package edu.stevens.cs548.clinic.domain;

import java.util.Date;


public class PatientFactory implements IPatientFactory {
	public Patient createPatient(long pid, String name, Date dob){
		Patient p = new Patient();
		p.setPatientId(pid);
		p.setName(name);
		p.setBirthDate(dob);
		return null;
	}
}
