package edu.stevens.cs548.clinic.domain;

import edu.stevens.cs548.clinic.domain.Treatment;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Radiology
 *
 */

@MappedSuperclass
public class Radiology extends Treatment implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String radiologist;
	private List<Date> dates;

	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getRadiologist() {
		return radiologist;
	}
	
	public void setRadiologist(String radiologist){ 
		this.radiologist = radiologist;
	}  
	
	public List<Date> getDates(){
		return dates;
	}
	
	public void setDates(List<Date> dates){
		this.dates = dates;
	}

	public void visit (ITreatmentVisitor visitor){
		visitor.visitRadiology( this.getId(),
									this.getDiagnosis(),
									this.radiologist,
									this.dates);
	}
	public Radiology() {
		super();
		dates = new ArrayList<Date>();
		this.setTreatmentType("R");
	}
}
