package com.adnexa.dto;

import lombok.Data;

@Data
public class InfluencerSearchRequest {
    private String category;
    private Long minFollowers;
    private Double maxPrice;
    private String location;
}