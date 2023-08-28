CREATE TABLE IF NOT EXISTS public.cars
(
    id SERIAL NOT NULL,
    car_name character varying(140) NOT NULL,
    created_at timestamp with time zone,
    CONSTRAINT cars_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS public.logs
(
    id SERIAL NOT NULL,
    current_odo INT NOT NULL,
    amount double precision NOT NULL,
    price_liter double precision NOT NULL,
    liters_per_100km double precision NOT NULL,
    liters double precision NOT NULL,
    car_id INT NOT NULL,
    last_tank_range double precision NOT NULL,
    created_at timestamp with time zone NOT NULL,
    CONSTRAINT logs_pkey PRIMARY KEY (id),
    CONSTRAINT "FK_car_logs" FOREIGN KEY (car_id)
        REFERENCES public.cars (id) MATCH SIMPLE
                ON UPDATE CASCADE
                ON DELETE CASCADE
);