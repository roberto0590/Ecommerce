CREATE TABLE public.usuario_rol
(
    id_usuario integer NOT NULL,
    id_rol integer NOT NULL,
    CONSTRAINT fk3ftpt75ebughsiy5g03b11akt FOREIGN KEY (id_usuario)
        REFERENCES public.usuario (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fkkxcv7htfnm9x1wkofnud0ewql FOREIGN KEY (id_rol)
        REFERENCES public.rol (id_rol) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)