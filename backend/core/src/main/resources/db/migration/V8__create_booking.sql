CREATE TABLE booking
(
    id           BIGSERIAL PRIMARY KEY,
    user_id      BIGINT         NOT NULL,
    event_id     BIGINT         NOT NULL,
    status       VARCHAR(20)    NOT NULL,
    total_amount NUMERIC(19, 2) NOT NULL,
    created_at   TIMESTAMP      NOT NULL,
    updated_at   TIMESTAMP      NOT NULL,

    CONSTRAINT fk_booking_user
        FOREIGN KEY (user_id)
            REFERENCES users (id),

    CONSTRAINT fk_booking_event
        FOREIGN KEY (event_id)
            REFERENCES events (id),

    CONSTRAINT chk_booking_status
        CHECK (status IN ('PENDING', 'CONFIRMED', 'CANCELLED', 'EXPIRED')),

    CONSTRAINT chk_booking_total_amount
        CHECK (total_amount >= 0)
);

CREATE INDEX idx_booking_user_id
    ON booking (user_id);

CREATE INDEX idx_booking_event_id
    ON booking (event_id);