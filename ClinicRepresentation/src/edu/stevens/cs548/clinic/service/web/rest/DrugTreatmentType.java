//
// ���ļ����� JavaTM Architecture for XML Binding (JAXB) ����ʵ�� v2.2.7 ���ɵ�
// ����� <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// �����±���Դģʽʱ, �Դ��ļ��������޸Ķ�����ʧ��
// ����ʱ��: 2014.03.24 ʱ�� 12:25:26 ���� PDT 
//


package edu.stevens.cs548.clinic.service.web.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>DrugTreatmentType complex type�� Java �ࡣ
 * 
 * <p>����ģʽƬ��ָ�������ڴ����е�Ԥ�����ݡ�
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
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "DrugTreatmentType", propOrder = {
    "dosage",
    "drug",
    "prescribingphysician"
})
public class DrugTreatmentType {

    protected float dosage;
    @XmlElement(required = true)
    protected String drug;
    @XmlElement(required = true)
    protected String prescribingphysician;

    /**
     * ��ȡdosage���Ե�ֵ��
     * 
     */
    public float getDosage() {
        return dosage;
    }

    /**
     * ����dosage���Ե�ֵ��
     * 
     */
    public void setDosage(float value) {
        this.dosage = value;
    }

    /**
     * ��ȡdrug���Ե�ֵ��
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
     * ����drug���Ե�ֵ��
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
     * ��ȡprescribingphysician���Ե�ֵ��
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
     * ����prescribingphysician���Ե�ֵ��
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
