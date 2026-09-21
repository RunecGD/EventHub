package org.example.core.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Index;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.core.dto.enums.EventOrganizerRole;
import org.example.core.dto.enums.EventOrganizerStatus;

import java.time.LocalDateTime;

@Entity
@Table(
        name = "event_organizers",
        uniqueConstraints = {
                @UniqueConstraint(
                        name = "uk_event_organizer",
                        columnNames = {"event_id", "organizer_id"}
                )
        },
        indexes = {
                @Index(
                        name = "idx_event_organizers_event_id",
                        columnList = "event_id"
                ),
                @Index(
                        name = "idx_event_organizers_organizer_id",
                        columnList = "organizer_id"
                )
        }
)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventOrganizer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "event_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_event_organizers_event")
    )
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(
            name = "organizer_id",
            nullable = false,
            foreignKey = @ForeignKey(name = "fk_event_organizers_organizer")
    )
    private OrganizerProfile organizer;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EventOrganizerRole role;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private EventOrganizerStatus status;

    @Column(name = "joined_at", nullable = false)
    private LocalDateTime joinedAt;

    @PrePersist
    protected void onCreate() {
        if (joinedAt == null) {
            joinedAt = LocalDateTime.now();
        }

        if (status == null) {
            status = EventOrganizerStatus.PENDING;
        }
    }

}