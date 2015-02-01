package edu.stevens.cs548.clinic.service.web.rest.resources;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
import edu.stevens.cs548.clinic.service.dto.patient.PatientDto;
import edu.stevens.cs548.clinic.service.dto.treatment.TreatmentDto;
import edu.stevens.cs548.clinic.service.ejb.IPatientService.PatientServiceExn;
import edu.stevens.cs548.clinic.service.ejb.IPatientServiceLocal;
import edu.stevens.cs548.clinic.service.web.rest.PatientRepresentation;
import edu.stevens.cs548.clinic.service.web.rest.TreatmentRepresentation;

@Path("/patient")
public class PatientResource {
    @Context
    private UriInfo context;
    
    final static Logger logger = Logger.getLogger(PatientResource.class.getCanonicalName());

    /**
     * Default constructor. 
     */
    public PatientResource() {
        // TODO Auto-generated constructor stub
    }
    

    private IPatientServiceLocal patientService;
    /**
     * Retrieves representation of an instance of PatientResource
     * @return an instance of String
     */
    @GET
    @Path("{id}")
    @Produces("application/xml")
    public PatientRepresentation getPatient(@PathParam("id") String id) {
        // TODO return proper representation object
        try {
    		long key = Long.parseLong(id);
    		PatientDto patientDTO = patientService.getPatientByDbId(key);
    		PatientRepresentation patientRep = new PatientRepresentation(patientDTO,context);
    		return patientRep;
    		// TODO return patient representation;
    	} catch (PatientServiceExn e) {
    		throw new WebApplicationException();
    	}
    }

    /**
     * PUT method for updating or creating an instance of PatientResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putPatient(PatientRepresentation content) {
    }
    
    /**
     * Query methods for patient resources.
     */
    @GET
    @Path("patientId")
    @Consumes("application/xml")
    public PatientRepresentation getPatientByPatientId (@QueryParam("id") String patientId) {
    	try {
    		long pid = Long.parseLong(patientId);
			PatientDto patientDTO = patientService.getPatientByPatId(pid);
    		//PatientRepresentation[] patientReps = new PatientRepresentation[patientDTO.length];
    		PatientRepresentation patientRep = new PatientRepresentation(patientDTO, context);
    		return patientRep;
    		// TODO return patient representation;
    	} catch (PatientServiceExn e) {
    		throw new WebApplicationException();
    	}  	
    }
    
    @GET
    @Produces("application/xml")
    public PatientRepresentation[] getPatientByNameDob (@QueryParam("name") String name,
		    @QueryParam("dob") Date dob) {
    			@SuppressWarnings("unused")
				Date birthDate = dob;
        		// TODO lookup patient based on name and DOB;
        		PatientDto[] patientDTO = patientService.getPatientsByNameDob(name, dob);
        		PatientRepresentation[] patientReps = new PatientRepresentation[patientDTO.length];
        		for ( int i=0;i<patientDTO.length; i++ ){
        			patientReps[i] = new PatientRepresentation(patientDTO[i],context);
        		}
        		//TODO return patient representation;
        		return patientReps;
    }
    
    @POST
    @Consumes("application/xml")
    public Response addPatient(PatientRepresentation patientRep) {
    	try {
    		// TODO add patient record;
    		long id = patientService.createPatient(patientRep.getName(),
    								  patientRep.getBirthDate(),
    								  patientRep.getPatientId());
    		UriBuilder ub = context.getAbsolutePathBuilder().path("{id}");
    		URI url = ub.build(Long.toString(id));
    		return Response.created(url).build();
    	} catch (PatientServiceExn e) {
    		throw new WebApplicationException();
    	}
    }
    
    public Response deletePatient(@PathParam("id") String id,
			  @QueryParam("name") String name) {
    	try {
    		long key = Long.parseLong(id);
    		patientService.deletePatient(name, key);
    		return Response.ok().build();
    	} catch (PatientServiceExn e) {
    		throw new WebApplicationException();
    	}
    }
    
    public TreatmentRepresentation[] getPatientTreatments(@PathParam("id") String id) {
    	try {
    		long key = Long.parseLong(id);
    		List<TreatmentDto> treatments = patientService.getTreatments(key, context); 
    		TreatmentRepresentation[] treatmentReps = new TreatmentRepresentation[treatments.size()];
    		for (int i=0; i < treatmentReps.length; i++) {
    			treatmentReps[i] = new TreatmentRepresentation(treatments.get(i), context);
    		}
    		return treatmentReps;
    	} catch (PatientServiceExn e) {
    		throw new WebApplicationException();
    	}
    }
}