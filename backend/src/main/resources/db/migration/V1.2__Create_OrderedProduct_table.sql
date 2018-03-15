DROP TABLE IF EXISTS ordered_product;

CREATE TABLE ordered_product
(
  id          INTEGER   NOT NULL
    CONSTRAINT ordered_product_pkey
    PRIMARY KEY,
  create_date TIMESTAMP NOT NULL,
  amount      INTEGER   NOT NULL,
  order_id    INTEGER   NOT NULL,
  product_id  INTEGER   NOT NULL
);

CREATE SEQUENCE ordered_product_sequence;