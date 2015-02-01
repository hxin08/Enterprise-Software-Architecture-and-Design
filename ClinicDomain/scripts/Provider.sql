--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."provider" DROP CONSTRAINT "provider_pkey";

DROP INDEX "public"."provider_pkey";

DROP TABLE "public"."provider";

CREATE TABLE "public"."provider" (
		"npi" INT8 NOT NULL,
		"id" INT8,
		"name" VARCHAR(255),
		"specialization" VARCHAR(255)
	);

CREATE UNIQUE INDEX "public"."provider_pkey" ON "public"."provider" ("npi" ASC);

ALTER TABLE "public"."provider" ADD CONSTRAINT "provider_pkey" PRIMARY KEY ("npi");

