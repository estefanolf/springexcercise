CREATE TABLE IF NOT EXISTS t_rates (
                                       ID SERIAL PRIMARY KEY NOT NULL,
                                       BRAND_ID INT NOT NULL,
                                       PRODUCT_ID INT NOT NULL,
                                       START_DATE DATE NOT NULL,
                                       END_DATE DATE NOT NULL,
                                       PRICE INT NOT NULL,
                                       CURRENCY_CODE VARCHAR(3) NOT NULL
    );

CREATE TABLE IF NOT EXISTS brand (
                                        ID SERIAL PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS product
(
                                        ID SERIAL PRIMARY KEY
);

