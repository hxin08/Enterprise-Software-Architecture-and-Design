(: XQuery main module :)

import schema namespace clin = "http://www.example.org/schemas/clinic" at "Clinic.xsd";

import schema namespace pat = "http://www.example.org/schemas/clinic/patient" at "Patient.xsd";

declare namespace trmt = "http://www.example.org/schemas/clinic/treatments";

import module namespace t = "http://www.example.com/xquery/clinic/TestExample" at "TestExample.xq";


let $clinic1 := doc("ClinicData.xml")/clin:Clinic
    return (t:getPatientTreatments($clinic1),
            t:getPatientDrugs($clinic1),
            t:getTreatmentInfo($clinic1),
            t:getProviderInfo($clinic1),
            t:getDrugInfo($clinic1)
           )


