module namespace test = 'http://www.example.com/xquery/clinic/TestExample';

import schema namespace clin = "http://www.example.org/schemas/clinic" at "Clinic.xsd";

import schema namespace pat = "http://www.example.org/schemas/clinic/patient" at "Patient.xsd";

import schema namespace prov = "http://www.example.org/schemas/clinic/provider" at "Provider.xsd";

declare namespace trmt = "http://www.example.org/schemas/clinic/treatment";

declare function test:getPatientTreatments ($klinic1 as element(clin:Clinic))
        as element(test:treatments) {
        <test:treatments> { $klinic1/pat:Patient[pat:name="John"]/pat:treatments} </test:treatments>
};


declare function test:getPatientDrugs ($klinic2 as element(clin:Clinic))
        as element(test:treatments) {
        <test:treatments> { $klinic2/pat:Patient[pat:name="AERIS"]/pat:treatments} </test:treatments>
};

declare function test:getTreatmentInfo ($klinic3 as element(clin:Clinic))
    as element(test:treatment)* {
    let $n1 := $klinic3/pat:Patient
    let $n2 := $klinic3/prov:Provider
    for $n3 in $n1/pat:treatments/pat:treatment/node() 
    return
    typeswitch ($n3)
    case $f as element(trmt:drug-treatment)
    return{ 
        <test:treatment>&#10;
        <test:treatment-type>"Drug-Treatment"</test:treatment-type>&#10;
        <test:drug-treatment> { $f } </test:drug-treatment>&#10;
        <test:patient-identifier>&#10;
        {
            for $c1 in $n1
                where $c1/pat:treatments/pat:treatment/trmt:drug-treatment = $f
            return 
            <info>
                <patient-id> { $c1/pat:patient-id/text() } </patient-id>&#10;
                <patient-name> { $c1/pat:name/text() } </patient-name>&#10;
                <patient-dob> { $c1/pat:dob/text() } </patient-dob>&#10;
            </info>
        }
        </test:patient-identifier>&#10;
        <test:provider-identifier>&#10; 
        { 
            for $d1 in $n2
                where $d1/prov:provider-id = $f/../trmt:provider-id
            return
            <info>
               <provider-id> { $d1/prov:provider-id/text() } </provider-id>&#10;
               <provider-name> { $d1/prov:name/text() } </provider-name>&#10;
               <specialization> { $d1/prov:specialization/text()} </specialization>&#10;
            </info>
        } 
        </test:provider-identifier>&#10;
        </test:treatment>
    }
    case $f as element(trmt:Radiology) 
    return{ 
        <test:treatment>&#10;
        <test:treatment-type>"Radiology"</test:treatment-type>&#10; 
        <test:Radiology> { $f } </test:Radiology>&#10;
        <test:patient-identifier>&#10;
        {
            for $c2 in $n1
                where $c2/pat:treatments/pat:treatment/trmt:Radiology = $f
            return 
            <info>
                <patient-id> { $c2/pat:patient-id/text() } </patient-id>&#10;
                <patient-name> { $c2/pat:name/text() } </patient-name>&#10;
                <patient-dob> { $c2/pat:dob/text() } </patient-dob>&#10;
            </info>
        }
        </test:patient-identifier>&#10;
        <test:provider-identifier>&#10; 
        { 
            for $d2 in $n2
                where $d2/prov:provider-id = $f/../trmt:provider-id
            return
            <info>
               <provider-id> { $d2/prov:provider-id/text() } </provider-id>&#10;
               <provider-name> { $d2/prov:name/text() } </provider-name>&#10;
               <specialization> { $d2/prov:specialization/text()} </specialization>&#10;
            </info>
        } 
        </test:provider-identifier>&#10;
        </test:treatment>
    }
    case $f as element(trmt:surgery)
    return{ 
        <test:treatment>&#10;
        <test:treatment-type>"Surgery"</test:treatment-type>&#10;
        <test:surgery> { $f } </test:surgery>&#10;
        <test:patient-identifier>&#10;
        {
            for $c3 in $n1
                where $c3/pat:treatments/pat:treatment/trmt:surgery = $f
            return 
            <info>
                <patient-id> { $c3/pat:patient-id/text() } </patient-id>&#10;
                <patient-name> { $c3/pat:name/text() } </patient-name>&#10;
                <patient-dob> { $c3/pat:dob/text() } </patient-dob>&#10;
            </info>
        }
        </test:patient-identifier>&#10;
        <test:provider-identifier>&#10; 
        { 
            for $d3 in $n2
                where $d3/prov:provider-id = $f/../trmt:provider-id
            return
            <info>
               <provider-id> { $d3/prov:provider-id/text() } </provider-id>&#10;
               <provider-name> { $d3/prov:name/text() } </provider-name>&#10;
               <specialization> { $d3/prov:specialization/text()} </specialization>&#10;
            </info>
        } 
        </test:provider-identifier>&#10;
        </test:treatment>
    }
    default return { }
};

declare function test:getProviderInfo ($klinic3 as element(clin:Clinic))
    as element(test:providerinfos) * {
    <test:providerinfos>&#10;
    {   
        for $x1 in $klinic3/prov:Provider   
        return 
        {
        <providerinfo>&#10;
               <provider-id> { $x1/prov:provider-id/text() } </provider-id>&#10;
               <provider-name> { $x1/prov:name/text() } </provider-name>&#10;
               <specialization> { $x1/prov:specialization/text()} </specialization> &#10;     
               <patientInfolist>&#10; 
               {
                    for $x2 in $klinic3/pat:Patient
                    where $x2/pat:treatments/pat:treatment/trmt:provider-id = $x1/prov:provider-id
                    return
                    {
                        <patientinfo>&#10; 
                            <patient-id> { $x2/pat:patient-id/text() } </patient-id>&#10;
                            <patient-name> { $x2/pat:name/text() } </patient-name>&#10;
                            <patient-dob> { $x2/pat:dob/text() } </patient-dob>&#10;    
                            <treatments>&#10;
                                {
                                for $x3 in $x2/pat:treatments/pat:treatment
                                where $x3/trmt:provider-id = $x1/prov:provider-id
                                return
                                {  
                                    <treatment>&#10;
                                    { $x3/text() }
                                    &#10;</treatment>
                                }
                            }&#10;</treatments>&#10; 
                        </patientinfo>   
                    }
               }&#10;
               </patientInfolist>&#10;   
        </providerinfo>}
    }&#10;
    </test:providerinfos>
};

declare function test:getDrugInfo ($klinic3 as element(clin:Clinic))
    as element(test:druginfo) * {
        for $n in $klinic3/pat:Patient/pat:treatments/pat:treatment/node()
        return
        typeswitch ($n)
        case $f as element(trmt:drug-treatment)
        return{ 
        <test:druginfo>&#10;
            <drug-name> { $f/trmt:drug/text() } </drug-name>&#10;
            <patientinfolist>&#10;
            {   
                for $n1 in $klinic3/pat:Patient
                where $n1/pat:treatments/pat:treatment/trmt:drug-treatment/trmt:drug = $f/trmt:drug
                return{
                <patient-info>&#10;
                    <patient-id> { $n1/pat:patient-id/text() } </patient-id>&#10;
                    <patient-name> { $n1/pat:name/text() } </patient-name>&#10;
                    <patient-dob> { $n1/pat:dob/text() } </patient-dob>&#10;
                    <diagnosis>{ $n1/pat:treatments/pat:treatment/trmt:diagnosis/text() }</diagnosis>&#10;
                    <prescribingphysician> { $n1/pat:treatments/pat:treatment/trmt:drug-treatment/trmt:prescribingphysician/text() } </prescribingphysician>&#10;
                </patient-info>
                }
            }&#10;</patientinfolist>&#10;
        </test:druginfo>
        }
        default return { }
};