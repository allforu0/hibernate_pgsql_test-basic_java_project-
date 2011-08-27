-- Table: test1

-- DROP TABLE test1;

CREATE TABLE test1
(
  idx integer NOT NULL,
  text1 text,
  text2 text,
  created date,
  updated date,
  CONSTRAINT idx PRIMARY KEY (idx)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE test1 OWNER TO postgres;

-- Sequence: seq_id_test1

-- DROP SEQUENCE seq_id_test1;

CREATE SEQUENCE seq_id_test1
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;
ALTER TABLE seq_id_test1 OWNER TO postgres;
