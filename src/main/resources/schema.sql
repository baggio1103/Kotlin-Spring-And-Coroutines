CREATE TABLE companies
(
    id      SERIAL PRIMARY KEY,
    name    VARCHAR(255),
    address VARCHAR(255)
);

CREATE TABLE users
(
    id         SERIAL PRIMARY KEY,
    name       VARCHAR(255),
    age        SMALLINT,
    email      VARCHAR(255),
    company_id BIGINT,
    CONSTRAINT company_fk FOREIGN KEY (company_id)
        REFERENCES companies (id)

);