package edu.stevens.cs548.clinic.service.web.rest;

import edu.stevens.cs548.clinic.domain.Patient;
import edu.stevens.cs548.clinic.domain.Treatment;
import edu.stevens.cs548.clinic.service.dto.treatment.PatientDto;
import edu.stevens.cs548.clinic.service.web.rest.data.PatientType;

import java.util.List;

import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import edu.stevens.cs548.clinic.service.web.rest.data.LinkType;

public class PatientRepresentation extends PatientType {
	public List<LinkType> getLinksTreatments() {
		return this.getTreatments();
	}
	
	public PatientRepresentation () {
		super();
	}
	
	public PatientRepresentation (PatientDto dto, UriInfo uriInfo){
		this.id =dto.id;
		this.patientId = dto.patientId;
		this.name = dto.name;
		this.birthDate= dto.birthDate;
		UriBuilder ub = uriInfo.getBaseUriBuilder();
		ub.path("treatment");
		/*
		 * Call getTreatment to initialize empty list.
		*/
	    List<LinkType> links = this.getTreatments();
	    // TODO add treatment representations
	    for (@SuppressWarnings("unused") LinkType t :treatments) {
	    	LinkType link = new LinkType();
	    	UriBuilder ubTreatment = ub.clone().path("{tid}");
	    	ubTreatment.path("{tid}");
	        String treatmentURI = ubTreatment.build(Treatment.class).toString();
	        link.setUrl(treatmentURI);
	    	link.setRelation(Representation.RELATION_TREATMENT);
	    	link.setMediaType(Representation.MEDIA_TYPE);
	    	links.add(link);
	    }
	}
	
	public static LinkType getPatientLink(Patient uriInfo, UriInfo uriInfo1) {
		UriBuilder ub = uriInfo1.getBaseUriBuilder();
		ub.path("patient").path("{id}");
		String patientURI = ub.build().toString();
		LinkType link = new LinkType();
		link.setUrl(patientURI);
		link.setRelation(Representation.RELATION_PATIENT);
		link.setMediaType(Representation.MEDIA_TYPE);
		return link;
	}
}
