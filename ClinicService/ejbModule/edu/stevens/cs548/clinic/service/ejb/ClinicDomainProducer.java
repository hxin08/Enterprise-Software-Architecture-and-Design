package edu.stevens.cs548.clinic.service.ejb;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Qualifier;
import javax.persistence.EntityManager;

/**
 * Session Bean implementation class ServiceProducer
 */
@Stateless
@LocalBean
public class ClinicDomainProducer {
    /**
     * Default constructor. 
     */
    public ClinicDomainProducer() {
    }
    
    @Qualifier  
    @Retention(RetentionPolicy.RUNTIME)  
    @Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})  
    public @interface ClinicDomain {}
    
    // TODO dependency injection of EntityManager
    EntityManager em;
    
    @Produces @ClinicDomain
    public EntityManager clinicDomainProducer() {
    	return em;
    }
    
    public void clinicDomainDispose(@Disposes EntityManager em) {
    	
    }
}
