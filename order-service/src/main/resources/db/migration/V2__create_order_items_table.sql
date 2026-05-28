CREATE TABLE order_items
(

    id           UUID PRIMARY KEY,

    order_id     UUID           NOT NULL,

    product_id   UUID           NOT NULL,

    product_name VARCHAR(255)   NOT NULL,

    quantity     INTEGER        NOT NULL,

    unit_price   NUMERIC(10, 2) NOT NULL,

    total_price  NUMERIC(10, 2) NOT NULL,

    created_at   TIMESTAMP      NOT NULL,

    FOREIGN KEY (order_id) REFERENCES orders (id)
);