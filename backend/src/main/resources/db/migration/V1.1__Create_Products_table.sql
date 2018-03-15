DROP TABLE IF EXISTS products;

CREATE TABLE products
(
  id           INTEGER      NOT NULL
    CONSTRAINT products_pkey
    PRIMARY KEY,
  create_date  TIMESTAMP    NOT NULL,
  description  VARCHAR(255),
  name         VARCHAR(255) NOT NULL,
  price        INTEGER      NOT NULL
    CONSTRAINT products_price_check
    CHECK (price >= 0),
  quantity     INTEGER      NOT NULL
    CONSTRAINT products_quantity_check
    CHECK (quantity >= 0),
  type         VARCHAR(255) NOT NULL,
  flowers_type VARCHAR(255) NOT NULL
);

CREATE SEQUENCE products_sequence;