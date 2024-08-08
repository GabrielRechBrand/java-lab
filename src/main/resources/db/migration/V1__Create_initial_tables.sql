CREATE TABLE cargo
(
    id                      UUID NOT NULL,
    created_at              TIMESTAMP WITHOUT TIME ZONE,
    updated_at              TIMESTAMP WITHOUT TIME ZONE,
    departure_date          TIMESTAMP WITHOUT TIME ZONE,
    arrival_date            TIMESTAMP WITHOUT TIME ZONE,
    origin                  VARCHAR(255),
    destination             VARCHAR(255),
    status                  SMALLINT,
    total_weight            DECIMAL,
    volume                  DECIMAL,
    temperature             DECIMAL,
    hazardous_material      BOOLEAN,
    insurance_policy_number VARCHAR(255),
    loading_start_time      TIMESTAMP WITHOUT TIME ZONE,
    loading_end_time        TIMESTAMP WITHOUT TIME ZONE,
    unloading_start_time    TIMESTAMP WITHOUT TIME ZONE,
    unloading_end_time      TIMESTAMP WITHOUT TIME ZONE,
    notes                   VARCHAR(255),
    truck_id                UUID,
    CONSTRAINT pk_cargo PRIMARY KEY (id)
);

CREATE TABLE cargo_product
(
    cargo_id   UUID NOT NULL,
    product_id UUID NOT NULL,
    CONSTRAINT pk_cargo_product PRIMARY KEY (cargo_id, product_id)
);

CREATE TABLE "order"
(
    id          UUID NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    customer_id UUID,
    CONSTRAINT pk_order PRIMARY KEY (id)
);

CREATE TABLE order_product
(
    order_id   UUID NOT NULL,
    product_id UUID NOT NULL,
    CONSTRAINT pk_order_product PRIMARY KEY (order_id, product_id)
);

CREATE TABLE product
(
    id          UUID NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    name        VARCHAR(255),
    description VARCHAR(255),
    price       DECIMAL,
    stock       INTEGER NOT NULL,
    status      SMALLINT,
    category    SMALLINT,
    weight      DECIMAL,
    company_id  UUID,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE review
(
    id          UUID         NOT NULL,
    created_at  TIMESTAMP WITHOUT TIME ZONE,
    updated_at  TIMESTAMP WITHOUT TIME ZONE,
    title       VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    rating      INTEGER      NOT NULL,
    subject_id  UUID         NOT NULL,
    product_id  UUID,
    order_id    UUID,
    CONSTRAINT pk_review PRIMARY KEY (id)
);

CREATE TABLE subject
(
    id         UUID NOT NULL,
    created_at TIMESTAMP WITHOUT TIME ZONE,
    updated_at TIMESTAMP WITHOUT TIME ZONE,
    name       VARCHAR(255),
    email      VARCHAR(255),
    phone      VARCHAR(255),
    address    VARCHAR(255),
    type       SMALLINT,
    CONSTRAINT pk_subject PRIMARY KEY (id)
);

CREATE TABLE truck
(
    id                  UUID NOT NULL,
    created_at          TIMESTAMP WITHOUT TIME ZONE,
    updated_at          TIMESTAMP WITHOUT TIME ZONE,
    active              BOOLEAN,
    truck_number        VARCHAR(255),
    model               VARCHAR(255),
    manufacturer        VARCHAR(255),
    year_of_manufacture INTEGER,
    license_plate       VARCHAR(255),
    capacity            DECIMAL,
    CONSTRAINT pk_truck PRIMARY KEY (id)
);

ALTER TABLE cargo ADD CONSTRAINT fk_cargo_on_truck FOREIGN KEY (truck_id) REFERENCES truck (id);
ALTER TABLE "order" ADD CONSTRAINT fk_order_on_customer FOREIGN KEY (customer_id) REFERENCES subject (id);
ALTER TABLE product ADD CONSTRAINT fk_product_on_company FOREIGN KEY (company_id) REFERENCES subject (id);
ALTER TABLE review ADD CONSTRAINT fk_review_on_order FOREIGN KEY (order_id) REFERENCES "order" (id);
ALTER TABLE review ADD CONSTRAINT fk_review_on_product FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE review ADD CONSTRAINT fk_review_on_subject FOREIGN KEY (subject_id) REFERENCES subject (id);
ALTER TABLE cargo_product ADD CONSTRAINT fk_carpro_on_cargo FOREIGN KEY (cargo_id) REFERENCES cargo (id);
ALTER TABLE cargo_product ADD CONSTRAINT fk_carpro_on_product FOREIGN KEY (product_id) REFERENCES product (id);
ALTER TABLE order_product ADD CONSTRAINT fk_ordpro_on_order FOREIGN KEY (order_id) REFERENCES "order" (id);
ALTER TABLE order_product ADD CONSTRAINT fk_ordpro_on_product FOREIGN KEY (product_id) REFERENCES product (id);