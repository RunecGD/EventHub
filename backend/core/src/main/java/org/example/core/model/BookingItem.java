package org.example.core.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "booking_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BookingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "booking_id")
    private Long bookingID;
    @Column(nullable = false, name = "ticket_type_id")
    private Long ticketTypeID;
    @Column(nullable = false, name = "quantity")
    private Integer quantity;
    @Column(nullable = false, name = "unit_price")
    private BigDecimal unitPrice;
    @Column(nullable = false, name = "total_price")
    private BigDecimal totalPrice;
}
