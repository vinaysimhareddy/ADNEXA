package com.adnexa.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class CampaignResponse {
    private Long id;
    private String title;
    private String description;
    private String category;
    private Double budget;
    private String platform;
    private LocalDate deadline;
    private String status;
    private String advertiserName;
}