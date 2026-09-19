package org.example.core.model;

import jakarta.persistence.*;
import lombok.*;
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