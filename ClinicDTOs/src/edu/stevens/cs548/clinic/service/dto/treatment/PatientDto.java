//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.12.17 at 04:27:43 PM PST 
//


package edu.stevens.cs548.clinic.service.dto.treatment;


import java.util.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

import edu.stevens.cs548.clinic.domain.Patient;


/**
 * <p>Java class for patientDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="patientDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="patient-id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="birthDate" type="{http://www.w3.org/2001/XMLSchema}date"/>
 *         &lt;element name="treatments" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "patientDTO", propOrder = {
    "id",
    "patientId",
    "name",
    "birthDate",
    "treatments"
})
public class PatientDto {

	public long id;
    @XmlElement(name = "patient-id")
    public long patientId;
    @XmlElement(required = true)
    public String name;
    @XmlElement(required = true)
    @XmlSchemaType(name = "date")
    public Date birthDate;
    public long[] treatments;
    public PatientDto(){ }
    public PatientDto(Patient patient) {
		this.id = patient.getId();
		this.patientId = patient.getPatientId();
		this.name =patient.getName();
		this.birthDate = patient.getBirthday();
		this.treatments = new long[patient.getTreatments().size()];
		for (int i=0; i<treatments.length; i++){
			this.treatments[i] = patient.getTreatments().get(i).getId();
		}
    }
    /**
     * Gets the value of the id property.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Gets the value of the patientId property.
     * 
     */
    public long getPatientId() {
        return patientId;
    }

    /**
     * Sets the value of the patientId property.
     * 
     */
    public void setPatientId(long value) {
        this.patientId = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the birthDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Sets the value of the birthDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBirthDate(Date value) {
        this.birthDate = value;
    }

    /**
     * Gets the value of the treatments property.
     * 
     */
    public long[] getTreatments() {
        return treatments;
    }

    /**
     * Sets the value of the treatments property.
     * 
     */
    public void setTreatments(long[] value) {
        this.treatments = value;
    }

}
