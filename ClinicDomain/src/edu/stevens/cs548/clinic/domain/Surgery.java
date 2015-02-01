package edu.stevens.cs548.clinic.domain;

import edu.stevens.cs548.clinic.domain.Treatment;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Surgery
 *
 */
@MappedSuperclass
public class Surgery extends Treatment implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String surgeon;
	@Temporal(TemporalType.DATE)
	private Date surgeryDate;
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public String getSurgeon(){
		return surgeon;
	}
	
	public void setSurgeon(String surgeon){
		this.surgeon = surgeon;
	}
	
	public Date getSurgeryDate(){
		return surgeryDate;
	}
	
	public void setSurgeryDate(Date surgeryDate){
		this.surgeryDate = surgeryDate;
	}
	
	public void visit (ITreatmentVisitor visitor){
		visitor.visitSurgery( this.getId(),
									this.getDiagnosis(),
									this.surgeon,
									this.surgeryDate);
	}
	
	public Surgery() {
		super();
		this.setTreatmentType("S");
	}
}
