package edu.stevens.cs548.clinic.domain;

import java.io.Serializable;
import javax.persistence.*;
import edu.stevens.cs548.clinic.domain.ITreatmentDAO.TreatmentExn;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static javax.persistence.CascadeType.REMOVE;

/**
 * Entity implementation class for Entity: Provider
 *
 */
@Entity
@Table(name = "PROVIDER")
@NamedQueries({
    @NamedQuery(
		name="SearchProviderByNameDOB",
		query="select p from Provider p where p.name = :name and p.specialization = :specialization"),
    @NamedQuery(
		name="SearchProviderByNamePatientID",
		query="select p from Provider p where p.NPI = :pid")
})

public class Provider implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	private long id;
	private long NPI;
	private String name;
	private String specialization;
	
	
	public long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public long getNPI() {
		return NPI;
	}
	
	public void setNPI(long NPI){
		this.NPI = NPI;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name =name;
	}
	
	public String getSpecialization() {
		return specialization;
	}
	
	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}
	
	@OneToMany(mappedBy = "provider",cascade = REMOVE,targetEntity = edu.stevens.cs548.clinic.domain.Treatment.class)
	@OrderBy
	private List<Treatment> treatments;
	
	public List<Treatment> getTreatments(){
		return treatments;
	}
	
	public void setTreatments(List<Treatment> treatments){
		this.treatments = treatments;
	}
	
	@Transient
	private ITreatmentDAO treatmentDAO;
	
	public void setTreatmentDAO (ITreatmentDAO tdao) {
		this.treatmentDAO = tdao;
	}
	//
	protected long addTreatment (Treatment t){
		this.treatmentDAO.addTreatment(t);
		this.getTreatments().add(t);
		if (t.getProvider() != this)
			t.setProvider(this);
		return t.getId();
	}
	//
	protected long addTreatment (Treatment t, Patient p) {
		this.treatmentDAO.addTreatment(t, p);
		this.getTreatments().add(t);
		if (t.getProvider() != this)
			t.setProvider(this);
		return t.getId();
	}
	//
	public List<Long> getTreatmentIds() {
		List<Long> tids = new ArrayList<Long>();
		for (Treatment t : this.getTreatments()){
			tids.add(t.getId());
		}
		return tids;
	}
	//
	public List<Long> getTreatmentIds(Patient p) {
		List<Long> tids = new ArrayList<Long>();
		List<Long> ptids= p.getTreatmentIds();
		for(int i=0;i<ptids.size();i++){
		for (Treatment t : this.getTreatments()) {
			if(ptids.get(i)==t.getId())
			tids.add(t.getId());
		}
		}
		return tids;
	}
	//
	public void visitTreatment(long tid, ITreatmentVisitor visitor) throws TreatmentExn{
			Treatment t = treatmentDAO.getTreatmentByDbId(tid);
			if (t.getProvider() == this) {
				throw new TreatmentExn("Inappropriate treatment access: patient = "+id
						+",treatment = "+tid);
			}
		t.visit(visitor);
	}
	//
	public void deleteTreatment(long tid) throws TreatmentExn{
		Treatment t = treatmentDAO.getTreatmentByDbId(tid);
		if (t.getProvider() == this) {
			throw new TreatmentExn("Inappropriate treatment access: patient = "+id
					+",treatment = "+tid);
		}
		treatmentDAO.deleteTreatment(t);
	}
	//
	public void visitTreatments (ITreatmentVisitor visitor){
		for (Treatment t :this.getTreatments()) {
			t.visit(visitor);
		}
	}
	
	public void addDrugTreatment (String diagnosis, String drug,float dosage){
		/*
		 * TODO:Add provider parameter when adding treatments to a patient.
		 */
		DrugTreatment treatment = new DrugTreatment();
		treatment.setDiagnosis(diagnosis);
		treatment.setDrug(drug);
		treatment.setDosage(dosage);
		this.addTreatment(treatment);
	}
	
	public void addRadiology (String diagnosis, String radiologist,List<Date> dates){
		/*
		 * TODO:Add provider parameter when adding treatments to a patient.
		 */
		Radiology treatment = new Radiology();
		treatment.setDiagnosis(diagnosis);
		treatment.setRadiologist(radiologist);
		treatment.setDates(dates);
		this.addTreatment(treatment);
	}
	
	public void addSurgery (String diagnosis, String surgeon,Date surgeryDate){
		/*
		 * TODO:Add provider parameter when adding treatments to a patient.
		 */
		Surgery treatment = new Surgery();
		treatment.setDiagnosis(diagnosis);
		treatment.setSurgeon(surgeon);
		treatment.setSurgeryDate(surgeryDate);
		this.addTreatment(treatment);
	}
	
	public Provider() {
		super();
		treatments = new ArrayList<Treatment>();
	}
}
