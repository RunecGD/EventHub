CREATE TABLE venues
(
    id          BIGSERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    address     VARCHAR(500) NOT NULL,
    city        VARCHAR(100) NOT NULL,
    description VARCHAR(1000),
    capacity    INTEGER      NOT NULL,
    created_at  TIMESTAMP    NOT NULL,
    updated_at  TIMESTAMP    NOT NULL,

    CONSTRAINT chk_venues_capacity
        CHECK (capacity > 0)
);