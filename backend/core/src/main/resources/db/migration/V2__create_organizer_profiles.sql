CREATE TABLE organizer_profiles
(
    id                BIGSERIAL PRIMARY KEY,
    user_id           BIGINT       NOT NULL UNIQUE,
    organization_name VARCHAR(255) NOT NULL,
    description       VARCHAR(2000),
    phone             VARCHAR(50),
    status            VARCHAR(20)  NOT NULL,
    created_at        TIMESTAMP    NOT NULL,
    updated_at        TIMESTAMP    NOT NULL,

    CONSTRAINT fk_organizer_profiles_user
        FOREIGN KEY (user_id)
            REFERENCES users (id),

    CONSTRAINT chk_organizer_profile_status
        CHECK (status IN ('PENDING', 'APPROVED', 'REJECTED', 'SUSPENDED'))
);