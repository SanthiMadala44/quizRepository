-- Table: public.question

-- DROP TABLE IF EXISTS public.question;

CREATE TABLE IF NOT EXISTS public.question
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    category text COLLATE pg_catalog."default",
    difficultylevel text COLLATE pg_catalog."default",
    option1 text COLLATE pg_catalog."default",
    option2 text COLLATE pg_catalog."default",
    option3 text COLLATE pg_catalog."default",
    option4 text COLLATE pg_catalog."default",
    question_title text COLLATE pg_catalog."default",
    right_answer text COLLATE pg_catalog."default",
    CONSTRAINT question_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.question
    OWNER to postgres;