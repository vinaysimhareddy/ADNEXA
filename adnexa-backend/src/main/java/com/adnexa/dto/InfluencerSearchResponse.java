package com.adnexa.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InfluencerSearchResponse {

    private String name;

    private String category;

    private Long instagramFollowers;

    private Long youtubeFollowers;

    private Long tiktokFollowers;

    private Double pricePerPost;
    
    private Double pricePerStory;
    
    private String location;
}