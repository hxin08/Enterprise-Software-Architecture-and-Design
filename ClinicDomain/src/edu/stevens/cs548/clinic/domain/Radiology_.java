package edu.stevens.cs548.clinic.domain;

import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-16T16:19:07.161-0500")
@StaticMetamodel(DrugTreatment.class)

public class Radiology_ {
	public static volatile SingularAttribute<Radiology, String> radiologist;
	public static volatile SingularAttribute<Radiology, List<Date>> dates;
}

