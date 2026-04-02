package com.adnexa.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InfluencerCardResponse {
    private String name;
    private String category;
    private long followers;
    private Double price;
    private String location;
    private String bio;
}