package edu.stevens.cs548.clinic.domain;

import java.util.Date;


import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-16T16:19:07.161-0500")
@StaticMetamodel(DrugTreatment.class)

public class Surgery_ {
	public static volatile SingularAttribute<Surgery, String> surgeon;
	public static volatile SingularAttribute<Surgery, Date> surgeryDate;
}