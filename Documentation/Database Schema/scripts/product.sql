CREATE TABLE public.product
(
    id_product integer NOT NULL,
    category character varying(1000) COLLATE pg_catalog."default",
    description character varying(1000) COLLATE pg_catalog."default",
    image character varying(1000) COLLATE pg_catalog."default",
    price double precision,
    title character varying(1000) COLLATE pg_catalog."default",
    CONSTRAINT product_pkey PRIMARY KEY (id_product)
)