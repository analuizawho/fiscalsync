CREATE TABLE orders
(

    id               UUID PRIMARY KEY,

    external_id      VARCHAR(50)    NOT NULL UNIQUE,

    customer_id      UUID           NOT NULL,

    total_amount     NUMERIC(10, 2) NOT NULL,

    status           VARCHAR(50)    NOT NULL,

    payment_method   VARCHAR(50),

    shipping_address TEXT,

    correlation_id   UUID,

    version          BIGINT DEFAULT 0,

    created_at       TIMESTAMP      NOT NULL,

    updated_at       TIMESTAMP

);