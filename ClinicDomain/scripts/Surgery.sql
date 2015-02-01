--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."surgery" DROP CONSTRAINT "fk_surgery_id";

ALTER TABLE "public"."surgery" DROP CONSTRAINT "surgery_pkey";

DROP INDEX "public"."surgery_pkey";

DROP TABLE "public"."surgery";

CREATE TABLE "public"."surgery" (
		"id" INT8 NOT NULL,
		"surgeon" VARCHAR(255),
		"surgerydate" DATE
	);

CREATE UNIQUE INDEX "public"."surgery_pkey" ON "public"."surgery" ("id" ASC);

ALTER TABLE "public"."surgery" ADD CONSTRAINT "surgery_pkey" PRIMARY KEY ("id");

ALTER TABLE "public"."surgery" ADD CONSTRAINT "fk_surgery_id" FOREIGN KEY ("id")
	REFERENCES "public"."treatment" ("id");

