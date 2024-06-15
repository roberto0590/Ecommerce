CREATE TABLE public.usuario
(
    id_usuario integer NOT NULL,
    estado boolean NOT NULL,
    clave character varying(255) COLLATE pg_catalog."default" NOT NULL,
    nombre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario),
    CONSTRAINT uk_cto7dkti4t38iq8r4cqesbd8k UNIQUE (nombre)
)