package com.adnexa.dto;

import java.time.LocalDate;
import lombok.Builder;
import lombok.Data;

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