//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.23 at 03:49:03 PM PDT 
//


package edu.stevens.cs548.clinic.service.dto.patient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import edu.stevens.cs548.clinic.service.dto.treatment.PatientDto;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.stevens.cs548.clinic.service.dto.patient package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _PatientDto_QNAME = new QName("http://cs548.stevens.edu/clinic/schemas/patient", "patient-dto");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.stevens.cs548.clinic.service.dto.patient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link PatientDto }
     * 
     */
    public PatientDto createPatientDTO() {
        return new PatientDto();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PatientDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/schemas/patient", name = "patient-dto")
    public JAXBElement<PatientDto> createPatientDto(PatientDto value) {
        return new JAXBElement<PatientDto>(_PatientDto_QNAME, PatientDto.class, null, value);
    }
}