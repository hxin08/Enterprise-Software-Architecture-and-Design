package edu.stevens.cs548.clinic.service.web.rest;

import java.util.Date;
import java.util.List;

import edu.stevens.cs548.clinic.domain.ITreatmentVisitor;

public class Treatment_PDO_to_Representation implements ITreatmentVisitor {
	private TreatmentRepresentation rep;
	private SurgeryRepresentation Surgerydto;
	private RadiologyRepresentation Radiologydto;
	private DrugTreatmentRepresentation DrugTreatmentdto;
	public TreatmentRepresentation getRep() { return rep; }
	public void visitDrugTreatment(long tid, String diagnosis, String drug, float dosage, String prescribingphysician)
	{
		// TODO Auto-generated method stub
		DrugTreatmentdto = new DrugTreatmentRepresentation(tid, prescribingphysician, dosage);
	}
	
	@Override
	public void visitRadiology(long tid, String diagnosis, String radiologist,
			List<Date> dates) {
		// TODO Auto-generated method stub
		Radiologydto = new RadiologyRepresentation(tid, dates);
	}
	@Override
	public void visitSurgery(long tid, String diagnosis, String surgeon,
			Date surgeryDate) {
		// TODO Auto-generated method stub
		Surgerydto = new SurgeryRepresentation(tid, surgeryDate);
	}	
}
