package edu.stevens.cs548.clinic.service.web.soap;

import java.util.Date;
import javax.jws.WebService;
import edu.stevens.cs548.clinic.service.dto.patient.PatientDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.TreatmentNotFoundExn;

@WebService(
	name="IPatientWebPort",
	targetNamespace="http://cs548.stevens.edu/clinic/service/web/soap")
/*
 * Endpoint interface for the patient Web service.
 */
public interface IPatientWebService {
	
	// TODO annotate for Web service
	public long addPatient (String name, Date dob, long patientId, int age) throws PatientServiceExn;

	// TODO annotate for Web service
	public PatientDTO getPatientByDbId (long id) throws PatientServiceExn;
	
	// TODO annotate for Web service
	public PatientDTO getPatientByPatId (long pid) throws PatientServiceExn;
	
	// TODO annotate for Web service
	public PatientDTO[] getPatientsByNameDob (String name, Date dob);
	
	// TODO annotate for Web service
	public void deletePatient (String name, long id) throws PatientServiceExn;
	
	// TODO annotate for Web service
	public TreatmentDto[] getTreatments(long id,long[] tids) throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn;

	// TODO annotate for Web service
	public String siteInfo();
}
