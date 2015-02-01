//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2013.11.27 at 07:27:06 PM PST 
//


package edu.stevens.cs548.clinic.service.dto;

//import javax.xml.bind.annotation.XmlAccessType;
//import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
//import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for DrugTreatmentType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="DrugTreatmentType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dosage" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="drug" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="prescribingphysician" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
/*
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DrugTreatmentType", propOrder = {
    "dosage",
    "drug",
    "prescribingphysician"
})
*/
public class DrugTreatmentType {

    protected float dosage;
    @XmlElement(required = true)
    protected String drug;
    @XmlElement(required = true)
    protected String prescribingphysician;

    /**
     * Gets the value of the dosage property.
     * 
     */
    public float getDosage() {
        return dosage;
    }

    /**
     * Sets the value of the dosage property.
     * 
     */
    public void setDosage(float value) {
        this.dosage = value;
    }

    /**
     * Gets the value of the drug property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDrug() {
        return drug;
    }

    /**
     * Sets the value of the drug property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDrug(String value) {
        this.drug = value;
    }

    /**
     * Gets the value of the prescribingphysician property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrescribingphysician() {
        return prescribingphysician;
    }

    /**
     * Sets the value of the prescribingphysician property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrescribingphysician(String value) {
        this.prescribingphysician = value;
    }
}