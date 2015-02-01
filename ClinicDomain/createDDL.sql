CREATE TABLE PATIENT (ID BIGINT NOT NULL, BIRTHDATE DATE, NAME VARCHAR(255), PATIENTID BIGINT, PRIMARY KEY (ID))
CREATE TABLE PROVIDER (ID BIGINT NOT NULL, NPI BIGINT, NAME VARCHAR(255), SPECIALIZATION VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE TREATMENT (ID BIGINT NOT NULL, TTYPE VARCHAR(31), DIAGNOSIS VARCHAR(255), patient_fk BIGINT, provider_fk BIGINT, PRIMARY KEY (ID))
ALTER TABLE TREATMENT ADD CONSTRAINT FK_TREATMENT_provider_fk FOREIGN KEY (provider_fk) REFERENCES PROVIDER (ID)
ALTER TABLE TREATMENT ADD CONSTRAINT FK_TREATMENT_patient_fk FOREIGN KEY (patient_fk) REFERENCES PATIENT (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
