CREATE TABLE booking_item
(
    id             BIGSERIAL PRIMARY KEY,
    booking_id     BIGINT         NOT NULL,
    ticket_type_id BIGINT         NOT NULL,
    quantity       INTEGER        NOT NULL,
    unit_price     NUMERIC(19, 2) NOT NULL,
    total_price    NUMERIC(19, 2) NOT NULL,

    CONSTRAINT fk_booking_item_booking
        FOREIGN KEY (booking_id)
            REFERENCES booking (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_booking_item_ticket_type
        FOREIGN KEY (ticket_type_id)
            REFERENCES ticket_types (id),

    CONSTRAINT chk_booking_item_quantity
        CHECK (quantity > 0),

    CONSTRAINT chk_booking_item_unit_price
        CHECK (unit_price >= 0),

    CONSTRAINT chk_booking_item_total_price
        CHECK (total_price >= 0)
);

CREATE INDEX idx_booking_item_booking_id
    ON booking_item (booking_id);

CREATE INDEX idx_booking_item_ticket_type_id
    ON booking_item (ticket_type_id);