//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.03.24 时间 12:25:26 上午 PDT 
//


package edu.stevens.cs548.clinic.service.web.rest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>LinkType complex type的 Java 类。
 * 
 * <p>以下模式片段指定包含在此类中的预期内容。
 * 
 * <pre>
 * &lt;complexType name="LinkType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="url" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="relation" type="{http://www.w3.org/2001/XMLSchema}anyURI" />
 *       &lt;attribute name="mediaType" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LinkType", namespace = "http://cs548.stevens.edu/clinic/service/web/rest/data/dap")
public class LinkType {

    @XmlAttribute(name = "url")
    @XmlSchemaType(name = "anyURI")
    protected String url;
    @XmlAttribute(name = "relation")
    @XmlSchemaType(name = "anyURI")
    protected String relation;
    @XmlAttribute(name = "mediaType")
    protected String mediaType;

    /**
     * 获取url属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrl(String value) {
        this.url = value;
    }

    /**
     * 获取relation属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelation() {
        return relation;
    }

    /**
     * 设置relation属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelation(String value) {
        this.relation = value;
    }

    /**
     * 获取mediaType属性的值。
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMediaType() {
        return mediaType;
    }

    /**
     * 设置mediaType属性的值。
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMediaType(String value) {
        this.mediaType = value;
    }

}
