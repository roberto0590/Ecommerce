CREATE TABLE public.detail_order
(
    id integer NOT NULL,
    amount double precision,
    orders integer NOT NULL,
    product integer NOT NULL,
    create_detail_order_date date,
    CONSTRAINT detail_order_pkey PRIMARY KEY (id),
    CONSTRAINT order_fk1 FOREIGN KEY (orders)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT product_fk1 FOREIGN KEY (product)
        REFERENCES public.product (id_product) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
        NOT VALID
)