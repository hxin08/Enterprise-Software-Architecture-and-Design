--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."patient" DROP CONSTRAINT "patient_pkey";

DROP INDEX "public"."patient_pkey";

DROP TABLE "public"."patient";

CREATE TABLE "public"."patient" (
		"patientid" INT8 NOT NULL,
		"birthdate" DATE,
		"id" INT8,
		"name" VARCHAR(255)
	);

CREATE UNIQUE INDEX "public"."patient_pkey" ON "public"."patient" ("patientid" ASC);

ALTER TABLE "public"."patient" ADD CONSTRAINT "patient_pkey" PRIMARY KEY ("patientid");

