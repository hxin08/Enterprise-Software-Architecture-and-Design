package edu.stevens.cs548.clinic.service.ejb;

import java.util.Date;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.ws.rs.core.UriInfo;

import edu.stevens.cs548.clinic.service.dto.patient.PatientDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;

public interface IPatientService {
	public class PatientServiceExn extends Exception {
		private static final long serialVersionUID = 1L;
		
		public PatientServiceExn (String m){
			super(m);
		}
	}
	
	public class PatientNotFoundExn extends PatientServiceExn{
		private static final long serialVersionUID = 1L;
		public PatientNotFoundExn (String m){
			super(m);
		}
	}
	
	public class TreatmentNotFoundExn extends PatientServiceExn{
		private static final long serialVersionUID = 1L;
		public TreatmentNotFoundExn (String m){
			super(m);
		}
	}
	
	public long createPatient (String name, Date dob, long patientId) throws PatientServiceExn, PatientServiceExn;
	
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
	
	public long deletePatient (String name, long id) throws PatientServiceExn;
	
	public long addDrugTreatment(long id, String diagnosis,String drug, float dosage) throws PatientServiceExn;
	
	public List<TreatmentDto> getTreatments(long id, UriInfo context) throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn;

	public void deleteTreatment(long id, long tid) throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn;
	
	public String siteInfo();
}
