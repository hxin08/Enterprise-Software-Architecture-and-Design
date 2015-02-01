--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."treatment" DROP CONSTRAINT "treatment_pkey";

DROP INDEX "public"."treatment_pkey";

DROP TABLE "public"."treatment";

CREATE TABLE "public"."treatment" (
		"id" INT8 NOT NULL,
		"ttype" VARCHAR(31),
		"diagnosis" VARCHAR(255),
		"patient_fk" INT8,
		"provider_fk" INT8
	);

CREATE UNIQUE INDEX "public"."treatment_pkey" ON "public"."treatment" ("id" ASC);

ALTER TABLE "public"."treatment" ADD CONSTRAINT "treatment_pkey" PRIMARY KEY ("id");

