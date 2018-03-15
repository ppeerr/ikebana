DROP TABLE IF EXISTS orders;

CREATE TABLE orders
(
  id                 INTEGER      NOT NULL
    CONSTRAINT orders_pkey
    PRIMARY KEY,
  create_date        TIMESTAMP    NOT NULL,
  address            VARCHAR(255) NOT NULL,
  phone_number       VARCHAR(255) NOT NULL,
  weeks_count        INTEGER      NOT NULL,
  selected_days_mask VARCHAR(255) NOT NULL,
  comment            VARCHAR(255),
  customer_name      VARCHAR(255) NOT NULL,
  start_date         DATE         NOT NULL,
  status             VARCHAR(255) NOT NULL,
  total_price        INTEGER      NOT NULL
    CONSTRAINT orders_total_price_check
    CHECK (total_price >= 0),
  last_status_check_date TIMESTAMP
);

CREATE SEQUENCE orders_sequence;