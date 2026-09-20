CREATE TABLE event_organizers
(
    id           BIGSERIAL PRIMARY KEY,
    event_id     BIGINT      NOT NULL,
    organizer_id BIGINT      NOT NULL,
    role         VARCHAR(20) NOT NULL,
    status       VARCHAR(20) NOT NULL,
    joined_at    TIMESTAMP   NOT NULL,

    CONSTRAINT fk_event_organizers_event
        FOREIGN KEY (event_id)
            REFERENCES events (id)
            ON DELETE CASCADE,

    CONSTRAINT fk_event_organizers_organizer
        FOREIGN KEY (organizer_id)
            REFERENCES organizer_profiles (id),

    CONSTRAINT uq_event_organizer
        UNIQUE (event_id, organizer_id),

    CONSTRAINT chk_event_organizer_role
        CHECK (role IN ('OWNER', 'ORGANIZER')),

    CONSTRAINT chk_event_organizer_status
        CHECK (status IN ('PENDING', 'ACTIVE', 'REMOVED'))
);

CREATE INDEX idx_event_organizers_event_id
    ON event_organizers(event_id);

CREATE INDEX idx_event_organizers_organizer_id
    ON event_organizers(organizer_id);