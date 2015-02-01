package edu.stevens.cs548.clinic.service.web.rest;

import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.web.rest.data.TreatmentType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import edu.stevens.cs548.clinic.service.web.rest.data.LinkType;
import edu.stevens.cs548.clinic.service.web.rest.data.ObjectFactory;

public class TreatmentRepresentation extends TreatmentType {

	private ObjectFactory repFactory = new ObjectFactory();
	
	public LinkType getLinkPatient() {
		return this.getPatient();
	}
	
	public LinkType getLinkProvider() {
		return this.getProvider();
	}
	
	public static LinkType getTreatmentLink(long tid, UriInfo uriInfo) {
		UriBuilder ub = uriInfo.getBaseUriBuilder();
		ub.path("treatment");
		UriBuilder ubTreatment = ub.clone().path("{tid}");
		String treatmentURI = ubTreatment.build(Long.toString(tid)).toString();
	
		LinkType link = new LinkType();
		link.setUrl(treatmentURI);
		link.setRelation(Representation.RELATION_TREATMENT);
		link.setMediaType(Representation.MEDIA_TYPE);
		return link;
	}

	public TreatmentRepresentation() {
		super();
	}
	
	public TreatmentRepresentation (TreatmentDto dto, UriInfo uriInfo) {
		this.patient =  PatientRepresentation.getPatientLink(dto.getPatient(), uriInfo);
		/*
		 * TODO: Need to fill in provider information.
		 */

		this.provider = null;
		
		this.diagnosis = dto.getDiagnosis();
		
		if (dto.getDrugTreatment() != null) {
			this.drugTreatment = repFactory.createDrugTreatmentType();
			this.drugTreatment.setDrug(dto.getDrugTreatment().getDrug());
			this.drugTreatment.setDosage(dto.getDrugTreatment().getDosage());
		} else if (dto.getSurgery() != null) {
			/*
			 * TODO finish this
			 */
			this.surgery = repFactory.createSurgeryType();
			this.surgery.setDate(dto.getSurgery().getDate());
			this.surgery.setSurgeon(dto.getSurgery().getSurgeon());
		} else if (dto.getRadiology() != null) {
			/*
			 * TODO finish this
			 */
			this.radiology = repFactory.createRadiologyType();
			this.radiology.setRadiologist(dto.getRadiology().getRadiologist());
		}
	}
}
