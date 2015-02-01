package edu.stevens.cs548.clinic.service.web.rest.resources;

import javax.ws.rs.ApplicationPath;

import sun.security.util.Resources;

@ApplicationPath("/resources")
public class WSConfiguration extends Resources {

	public WSConfiguration() {
		packages("edu.stevens.cs548.clinic.service.web.rest.resources");
	}

	private void packages(String string) {
		// TODO Auto-generated method stub
		
	}
}