CREATE TABLE events
(
    id          BIGSERIAL PRIMARY KEY,
    title       VARCHAR(255) NOT NULL,
    description TEXT,
    category_id BIGINT       NOT NULL,
    venue_id    BIGINT       NOT NULL,
    start_at    TIMESTAMP    NOT NULL,
    end_at      TIMESTAMP    NOT NULL,
    status      VARCHAR(20)  NOT NULL,
    created_at  TIMESTAMP    NOT NULL,
    updated_at  TIMESTAMP    NOT NULL,

    CONSTRAINT fk_events_category
        FOREIGN KEY (category_id)
            REFERENCES categories (id),

    CONSTRAINT fk_events_venue
        FOREIGN KEY (venue_id)
            REFERENCES venues (id),

    CONSTRAINT chk_events_dates
        CHECK (end_at > start_at),

    CONSTRAINT chk_events_status
        CHECK (
            status IN (
                       'DRAFT',
                       'PUBLISHED',
                       'CANCELLED',
                       'FINISHED'
                )
            )
);

CREATE INDEX idx_events_category_id
    ON events(category_id);

CREATE INDEX idx_events_venue_id
    ON events(venue_id);

CREATE INDEX idx_events_status
    ON events(status);