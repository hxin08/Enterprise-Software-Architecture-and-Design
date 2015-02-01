package edu.stevens.cs548.clinic.test;

import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Singleton;
//import ClinicTest.EntityManager;
//import ClinicTest.IPatientDAO;
//import ClinicTest.Logger;
//import ClinicTest.PatientDAO;
//import ClinicTest.PersistenceContext;
//import ClinicTest.PostConstruct;
//import ClinicTest.Startup;
//import ClinicTest.Test;
import javax.persistence.EntityManager;

import edu.stevens.cs548.clinic.domain.IPatientDAO;
import edu.stevens.cs548.clinic.domain.PatientDAO;

//import edu.stevens.cs548.clinic.domain.IPatientDAO;
//import edu.stevens.cs548.clinic.domain.PatientDAO;

/**
 * Session Bean implementation class TestBean
 */
@Singleton
@LocalBean
@Startup
public class TestBean{
	private static Logger logger = Logger.getLogger(TestBean.class.getCanonicalName());
	private static void info(String m)
	{
		logger.info(m);
	}
	public void TestDomain()
	{
		
	}
	@PersistenceContext(unitName="ClinicDomain")
	private EntityManager em;
	@PostConstruct
	public void init(){
		info("Initializing the user database.");
		IPatientDAO patientDAO = new PatientDAO(em);
		patientDAO.deleteAll();
		//Insert code to test the functions of your domain model
		//Use info(¡°...¡±) to display the results in the log
	}
}

