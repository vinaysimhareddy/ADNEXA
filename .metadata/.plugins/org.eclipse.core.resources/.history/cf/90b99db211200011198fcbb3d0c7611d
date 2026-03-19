package com.adnexa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "influencer_profiles")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfluencerProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private Integer instagramFollowers;

    private Integer youtubeFollowers;

    private Integer tiktokFollowers;

    private String category;

    private Double pricePerPost;

    private Double pricePerStory;

    private String bio;

    private String location;
}