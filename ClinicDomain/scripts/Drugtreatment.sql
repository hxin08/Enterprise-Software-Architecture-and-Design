--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."drugtreatment" DROP CONSTRAINT "fk_drugtreatment_id";

ALTER TABLE "public"."drugtreatment" DROP CONSTRAINT "drugtreatment_pkey";

DROP INDEX "public"."drugtreatment_pkey";

DROP TABLE "public"."drugtreatment";

CREATE TABLE "public"."drugtreatment" (
		"id" INT8 NOT NULL,
		"dosage" FLOAT8,
		"drug" VARCHAR(255),
		"prescribingphysician" VARCHAR(255)
	);

CREATE UNIQUE INDEX "public"."drugtreatment_pkey" ON "public"."drugtreatment" ("id" ASC);

ALTER TABLE "public"."drugtreatment" ADD CONSTRAINT "drugtreatment_pkey" PRIMARY KEY ("id");

ALTER TABLE "public"."drugtreatment" ADD CONSTRAINT "fk_drugtreatment_id" FOREIGN KEY ("id")
	REFERENCES "public"."treatment" ("id");

