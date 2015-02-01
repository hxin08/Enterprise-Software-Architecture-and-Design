package edu.stevens.cs548.clinic.service.web.rest;

import java.util.Date;

import edu.stevens.cs548.clinic.service.web.rest.data.SurgeryType;

public class SurgeryRepresentation extends SurgeryType {
	long id;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public SurgeryRepresentation(long id, Date date)
	{
		super.date = date;
		this.id = id;
	}
}
