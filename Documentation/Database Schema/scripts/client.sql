CREATE TABLE public.client
(
    id integer NOT NULL,
    address character varying(100) COLLATE pg_catalog."default",
    birthday date NOT NULL,
    email character varying(50) COLLATE pg_catalog."default",
    lastname character varying(50) COLLATE pg_catalog."default" NOT NULL,
    name character varying(50) COLLATE pg_catalog."default" NOT NULL,
    phone character varying(20) COLLATE pg_catalog."default",
    adresss character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT client_pkey PRIMARY KEY (id)
)