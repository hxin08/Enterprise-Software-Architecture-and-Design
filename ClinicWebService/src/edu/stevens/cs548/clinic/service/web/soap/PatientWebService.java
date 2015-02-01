package edu.stevens.cs548.clinic.service.web.soap;

import java.util.Date;
import java.util.List;

import javax.ws.rs.core.UriInfo;

import edu.stevens.cs548.clinic.service.dto.patient.PatientDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.TreatmentNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientServiceLocal;

// TODO Use JSR-181 annotations to specify Web service.

public class PatientWebService 

	implements IPatientWebService {

	// TODO dependency injection of EJB
	IPatientServiceLocal service;
	
	@Override
	public long addPatient(String name, Date dob, long patientId, int age)
			throws PatientServiceExn {
		return service.createPatient(name, dob, patientId);
	}

	@Override
	public PatientDTO getPatientByDbId(long id) throws PatientServiceExn {
		return service.getPatientByDbId(id);
	}

	@Override
	public PatientDTO getPatientByPatId(long pid) throws PatientServiceExn {
		return service.getPatientByPatId(pid);
	}

	@Override
	public PatientDTO[] getPatientsByNameDob(String name, Date dob) {
		return service.getPatientsByNameDob(name, dob);
	}

	@Override
	public void deletePatient(String name, long id) throws PatientServiceExn {
		this.service.deletePatient(name, id);
	}

	public List<TreatmentDto> getTreatments(long id, UriInfo tids)
			throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn {
		return service.getTreatments(id, tids);
	}

	@Override
	public String siteInfo() {
		return service.siteInfo();
	}

	@Override
	public TreatmentDto[] getTreatments(long id, long[] tids)
			throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn {
		// TODO Auto-generated method stub
		return null;
	}
		
}
