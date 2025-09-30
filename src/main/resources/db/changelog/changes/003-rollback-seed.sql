--liquibase formatted sql

--changeset andrey:rollback-persons
DELETE FROM persons WHERE name IN ('John Doe', 'Alice Doe');
