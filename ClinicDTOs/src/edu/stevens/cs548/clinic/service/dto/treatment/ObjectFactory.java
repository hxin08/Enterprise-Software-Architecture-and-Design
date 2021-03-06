//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.5-b10 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.03.23 at 02:15:21 AM PDT 
//


package edu.stevens.cs548.clinic.service.dto.treatment;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the edu.stevens.cs548.clinic.service.dto.treatment package. 
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

    private final static QName _Radiology_QNAME = new QName("http://cs548.stevens.edu/clinic/schemas/treatment", "Radiology");
    private final static QName _Surgery_QNAME = new QName("http://cs548.stevens.edu/clinic/schemas/treatment", "surgery");
    private final static QName _TreatmentDto_QNAME = new QName("http://cs548.stevens.edu/clinic/schemas/treatment", "treatment-dto");
    private final static QName _DrugTreatment_QNAME = new QName("http://cs548.stevens.edu/clinic/schemas/treatment", "drug-treatment");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: edu.stevens.cs548.clinic.service.dto.treatment
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DrugTreatmentType }
     * 
     */
    public DrugTreatmentType createDrugTreatmentType() {
        return new DrugTreatmentType();
    }

    /**
     * Create an instance of {@link TreatmentDto }
     * 
     */
    public TreatmentDto createTreatmentDTO() {
        return new TreatmentDto();
    }

    /**
     * Create an instance of {@link RadiologyType }
     * 
     */
    public RadiologyType createRadiologyType() {
        return new RadiologyType();
    }

    /**
     * Create an instance of {@link SurgeryType }
     * 
     */
    public SurgeryType createSurgeryType() {
        return new SurgeryType();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RadiologyType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/schemas/treatment", name = "Radiology")
    public JAXBElement<RadiologyType> createRadiology(RadiologyType value) {
        return new JAXBElement<RadiologyType>(_Radiology_QNAME, RadiologyType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SurgeryType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/schemas/treatment", name = "surgery")
    public JAXBElement<SurgeryType> createSurgery(SurgeryType value) {
        return new JAXBElement<SurgeryType>(_Surgery_QNAME, SurgeryType.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link TreatmentDto }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/schemas/treatment", name = "treatment-dto")
    public JAXBElement<TreatmentDto> createTreatmentDto(TreatmentDto value) {
        return new JAXBElement<TreatmentDto>(_TreatmentDto_QNAME, TreatmentDto.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DrugTreatmentType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://cs548.stevens.edu/clinic/schemas/treatment", name = "drug-treatment")
    public JAXBElement<DrugTreatmentType> createDrugTreatment(DrugTreatmentType value) {
        return new JAXBElement<DrugTreatmentType>(_DrugTreatment_QNAME, DrugTreatmentType.class, null, value);
    }

}
