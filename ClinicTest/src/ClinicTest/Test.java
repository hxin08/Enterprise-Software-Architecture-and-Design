package ClinicTest;

@Singleton
@LocalBean
@Startup
public class Test {
	private static Logger logger = Logger.getLogger(Test.class
			.getCanonicalName());

	private static void info(String m) {
		logger.info(m);
	}

	public Initialize() {
	}

	@PersistenceContext(unitName = "ClinicDomain")
	private EntityManager em;

	@PostConstruct
	public void init(){
			info("Initializing the user database.");
			IPatientDAO patientDAO = new PatientDAO(em);  
			patientDAO.deleteAll();
			roleDAO.deleteAll();
			//Insertcodetotestthefunctionsofyourdomainmodel
			//Useinfo(¡°...¡±)todisplaytheresultsinthelog
	}
}
