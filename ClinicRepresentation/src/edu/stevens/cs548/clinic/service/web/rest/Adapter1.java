//
// 此文件是由 JavaTM Architecture for XML Binding (JAXB) 引用实现 v2.2.7 生成的
// 请访问 <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// 在重新编译源模式时, 对此文件的所有修改都将丢失。
// 生成时间: 2014.03.24 时间 12:25:26 上午 PDT 
//


package edu.stevens.cs548.clinic.service.web.rest;

import java.util.Date;
import javax.xml.bind.annotation.adapters.XmlAdapter;

public class Adapter1
    extends XmlAdapter<String, Date>
{


    public Date unmarshal(String value) {
        return (edu.stevens.cs548.clinic.service.web.rest.data.DateAdapter.parseDate(value));
    }

    public String marshal(Date value) {
        return (edu.stevens.cs548.clinic.service.web.rest.data.DateAdapter.printDate(value));
    }

}
