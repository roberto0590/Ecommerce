CREATE TABLE public.rol
(
    id_rol integer NOT NULL,
    descripcion character varying(255) COLLATE pg_catalog."default",
    nombre character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT rol_pkey PRIMARY KEY (id_rol)
)