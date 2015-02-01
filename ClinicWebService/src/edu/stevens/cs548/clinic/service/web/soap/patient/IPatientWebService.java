package edu.stevens.cs548.clinic.service.web.soap.patient;

import java.util.Date;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;

import edu.stevens.cs548.clinic.domain.IPatientDAO.PatientExn;
import edu.stevens.cs548.clinic.service.dto.patient.PatientDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.TreatmentNotFoundExn;

@WebService(
name="IPatientWebPort",
targetNamespace="http://cs548.stevens.edu/clinic/service/web/soap/patient")
/*
 * Endpoint interface for the patient Web service.
*/

public interface IPatientWebService {

	
	@WebMethod(operationName="create")
	public long createPatient (String name, Date dob, long patientId) throws PatientServiceExn, PatientExn;
	
	@WebMethod
	@WebResult(name="PatientDto",
	  targetNamespace="http://cs548.stevens.edu/clinic/schemas/patient")
	public PatientDTO getPatientByDbId (long id) throws PatientServiceExn;
	
	@WebMethod
	@WebResult(name="PatientDto",
	  targetNamespace="http://cs548.stevens.edu/clinic/schemas/patient")
	public PatientDTO getPatientByPatId (long pid) throws PatientServiceExn;
	
	@WebMethod
	@WebResult(name="PatientDto",
	  targetNamespace="http://cs548.stevens.edu/clinic/schemas/patient")
	public PatientDTO[] getPatientsByNameDob (String name, Date dob);
	
	@WebMethod
	public long deletePatient (String name, long id) throws PatientServiceExn;
	
	@WebMethod
	public long addDrugTreatment(long id, String diagnosis,String drug, float dosage) throws PatientServiceExn;
	
	@WebMethod
	public TreatmentDto[] getTreatments(long id, long[] tids) throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn;
	
	@WebMethod
	public void deleteTreatment(long id, long tid) throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn;
	
	@WebMethod
	public String siteInfo();	
}
