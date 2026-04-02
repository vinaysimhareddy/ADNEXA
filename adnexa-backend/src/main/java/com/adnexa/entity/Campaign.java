package com.adnexa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Table(name = "campaigns")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Campaign {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String category;
    private Double budget;
    private String platform;
    private LocalDate deadline;

    private String status; // "OPEN", "CLOSED", "COMPLETED"

    @ManyToOne
    @JoinColumn(name = "advertiser_id")
    private User advertiser;
}