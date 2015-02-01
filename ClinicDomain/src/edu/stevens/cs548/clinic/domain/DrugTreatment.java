package edu.stevens.cs548.clinic.domain;

import edu.stevens.cs548.clinic.domain.Treatment;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DrugTreatment
 *
 */
@MappedSuperclass
@DiscriminatorValue("D")
public class DrugTreatment extends Treatment implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	private long id;
	private String drug;
	private float dosage;
	private String prescribingphysician;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getDrug() {
		return drug;
	}

	public void setDrug(String drug) {
		this.drug = drug;
	}

	public float getDosage() {
		return dosage;
	}

	public void setDosage(float dosage) {
		this.dosage = dosage;
	}
	
	public String getPrescribingphysician() {
		return prescribingphysician;
	}

	public void setPrescribingphysician(String prescribingphysician) {
		this.prescribingphysician = prescribingphysician;
	}
	
	public void visit (ITreatmentVisitor visitor){
		visitor.visitDrugTreatment( this.getId(),
									this.getDiagnosis(),
									this.drug,
									this.dosage,
									this.prescribingphysician);
	}
	
	public DrugTreatment() {
		super();
		this.setTreatmentType("D");
	}
}
