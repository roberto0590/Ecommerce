CREATE TABLE public.orders
(
    id integer NOT NULL,
    balance double precision NOT NULL,
    client integer NOT NULL,
    status integer,
    create_order_date date,
    CONSTRAINT orders_pkey PRIMARY KEY (id),
    CONSTRAINT client_fk FOREIGN KEY (client)
        REFERENCES public.client (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)