CREATE TABLE ticket_types
(
    id                BIGSERIAL PRIMARY KEY,
    event_id          BIGINT         NOT NULL,
    name              VARCHAR(255)   NOT NULL,
    description       VARCHAR(1000)  NOT NULL,
    price             NUMERIC(19, 2) NOT NULL,
    total_quantity    INTEGER        NOT NULL,
    available_quantity INTEGER        NOT NULL,
    created_at        TIMESTAMP      NOT NULL,
    updated_at        TIMESTAMP      NOT NULL,

    CONSTRAINT fk_ticket_types_event
        FOREIGN KEY (event_id)
            REFERENCES events (id)
            ON DELETE CASCADE,

    CONSTRAINT chk_ticket_types_price
        CHECK (price >= 0),

    CONSTRAINT chk_ticket_types_total_quantity
        CHECK (total_quantity > 0),

    CONSTRAINT chk_ticket_types_available_quantity
        CHECK (available_quantity >= 0),

    CONSTRAINT chk_ticket_types_available_lte_total
        CHECK (available_quantity <= total_quantity)
);

CREATE INDEX idx_ticket_types_event_id
    ON ticket_types(event_id);