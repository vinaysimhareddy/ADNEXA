package com.adnexa.entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "campaign_applications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CampaignApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Which campaign
    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    // Which influencer applied
    @ManyToOne
    @JoinColumn(name = "influencer_id")
    private User influencer;

    private String message;

    private String status; // PENDING, ACCEPTED, REJECTED

    private LocalDateTime appliedAt;
}