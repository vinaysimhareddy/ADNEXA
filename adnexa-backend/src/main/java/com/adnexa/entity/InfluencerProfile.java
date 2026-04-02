package com.adnexa.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "influencer_profiles")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InfluencerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Long instagramFollowers;
    private Long youtubeFollowers;
    private Long tiktokFollowers;

    private String category;
    private Double pricePerPost;
    private Double pricePerStory;

    private String bio;
    private String location;
}