package edu.stevens.cs548.clinic.service.web.rest;

import java.util.Date;
import java.util.List;

import edu.stevens.cs548.clinic.service.web.rest.data.RadiologyType;

public class RadiologyRepresentation extends RadiologyType {
	long id;
	public RadiologyRepresentation(long id, List<Date> date)
	{
		super.date = date;
		this.id = id;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
}
