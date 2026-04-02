package com.adnexa.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "campaign_applications")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CampaignApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "campaign_id")
    private Campaign campaign;

    @ManyToOne
    @JoinColumn(name = "influencer_id")
    private User influencer;

    private String message;

    private String status; // "PENDING", "ACCEPTED", "REJECTED"

    private LocalDateTime appliedAt;
}