package org.example.core.model;

import jakarta.persistence.*;
import lombok.*;
import org.example.core.dto.BookingStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "user_id")
    private Long userID;
    @Column(nullable = false, name = "event_id")
    private Long eventID;
    @Column(nullable = false, name = "status")
    private BookingStatus status;
    @Column(nullable = false, name = "total_amount")
    private BigDecimal totalAmount;
    @Column(nullable = false, name = "created_at")
    private LocalDateTime createdAt;
    @Column(nullable = false, name = "update_at")
    private LocalDateTime updateAt;
}
