package com.adnexa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfluencerProfileResponse {
    private Long instagramFollowers;
    private Long youtubeFollowers;
    private Long tiktokFollowers;
    private String category;
    private Double pricePerPost;
    private Double pricePerStory;
    private String bio;
    private String location;
}