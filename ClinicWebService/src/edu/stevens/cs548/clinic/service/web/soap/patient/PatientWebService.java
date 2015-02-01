package edu.stevens.cs548.clinic.service.web.soap.patient;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ws.rs.core.UriInfo;
import edu.stevens.cs548.clinic.domain.IPatientDAO.PatientExn;
import edu.stevens.cs548.clinic.service.dto.patient.PatientDTO;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.TreatmentNotFoundExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientServiceRemote;

@WebService(
	endpointInterface="edu.stevens.cs548.clinic.service.web.soap.patient.IPatientWebService",
	targetNamespace="http://cs548.stevens.edu/clinic/service/web/soap/patient",
	serviceName="PatientWebService",
	portName="PatientWebPort")

public class PatientWebService implements IPatientWebService{
	
	@EJB(beanName="PatientServiceBean")
	IPatientServiceRemote service;
	
	@Override
	public long createPatient(String name, Date dob, long patientId)
			throws PatientServiceExn, PatientExn {
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
		return service.getPatientsByNameDob(name,dob);
	}
	
	@Override
	public long deletePatient(String name, long id) throws PatientServiceExn {
		this.service.deletePatient(name, id);
		return 0;
	}
	
	@Override
	public long addDrugTreatment(long id, String diagnosis, String drug,
			float dosage) throws PatientServiceExn {
		this.service.addDrugTreatment(id, diagnosis, drug, dosage);
		return 0;
	}
	
	public List<TreatmentDto> getTreatments(long id, UriInfo tids)
			throws PatientNotFoundExn, TreatmentNotFoundExn, PatientServiceExn {
		return service.getTreatments(id, tids);
	}
	
	@Override
	public void deleteTreatment(long id, long tid) throws PatientNotFoundExn,
			TreatmentNotFoundExn, PatientServiceExn {
		this.service.deleteTreatment(id, tid);
	}
	
	@Resource(name="SiteInfo")
	private String siteInformation;
   
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
