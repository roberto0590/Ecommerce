CREATE TABLE public.pay
(
    id integer NOT NULL,
    balance double precision NOT NULL,
    orders integer NOT NULL,
    pay_date date,
    CONSTRAINT pay_pkey PRIMARY KEY (id),
    CONSTRAINT order_fk2 FOREIGN KEY (orders)
        REFERENCES public.orders (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)