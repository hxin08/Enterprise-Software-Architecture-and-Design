--<ScriptOptions statementTerminator=";"/>

ALTER TABLE "public"."radiology" DROP CONSTRAINT "fk_radiology_id";

ALTER TABLE "public"."radiology" DROP CONSTRAINT "radiology_pkey";

DROP INDEX "public"."radiology_pkey";

DROP TABLE "public"."radiology";

CREATE TABLE "public"."radiology" (
		"id" INT8 NOT NULL,
		"dates" BYTEA(2147483647),
		"radiologist" VARCHAR(255)
	);

CREATE UNIQUE INDEX "public"."radiology_pkey" ON "public"."radiology" ("id" ASC);

ALTER TABLE "public"."radiology" ADD CONSTRAINT "radiology_pkey" PRIMARY KEY ("id");

ALTER TABLE "public"."radiology" ADD CONSTRAINT "fk_radiology_id" FOREIGN KEY ("id")
	REFERENCES "public"."treatment" ("id");

