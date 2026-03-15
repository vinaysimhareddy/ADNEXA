package com.adnexa.dto;

import lombok.Data;

@Data
public class InfluencerProfileRequest {

    private Long instagramFollowers;
    private Long youtubeFollowers;
    private Long tiktokFollowers;

    private String category;
    private Double pricePerPost;
    private Double pricePerStory;

    private String bio;
    private String location;
}