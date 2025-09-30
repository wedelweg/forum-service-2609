--liquibase formatted sql

--changeset andrey:insert-persons
INSERT INTO persons (dtype, name, birth_date, city, street, building, company, salary, kindergarten)
VALUES
    ('Employee', 'John Doe', '1990-05-20', 'New York', '5th Avenue', 10, 'Tech Corp', 5000, NULL),
    ('Child', 'Alice Doe', '2015-08-15', 'New York', '5th Avenue', 10, NULL, NULL, 'Happy Kids');
