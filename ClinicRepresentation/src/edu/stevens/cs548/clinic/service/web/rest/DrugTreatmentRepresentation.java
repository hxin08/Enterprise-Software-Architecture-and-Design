package edu.stevens.cs548.clinic.service.web.rest;

import edu.stevens.cs548.clinic.service.web.rest.data.DrugTreatmentType;

public class DrugTreatmentRepresentation extends DrugTreatmentType {
	long id;
	public DrugTreatmentRepresentation(long id, String name, float dosage)
	{
		this.id = id;
		super.dosage = dosage;
		super.drug = drug;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
}
