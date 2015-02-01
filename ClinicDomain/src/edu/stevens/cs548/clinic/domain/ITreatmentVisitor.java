package edu.stevens.cs548.clinic.domain;

import java.util.Date;
import java.util.List;

public interface ITreatmentVisitor {
	
	public void visitDrugTreatment(long tid,
							   String diagnosis,
							   String drug,
							   float dosage, 
							   String prescribingphysician);

	public void visitRadiology (long tid,
								String diagnosis,
								String radiologist,
								List<Date> dates);
	
	public void visitSurgery (long tid,
							  String diagnosis,
							  String surgeon,
							  Date surgeryDate);
}
