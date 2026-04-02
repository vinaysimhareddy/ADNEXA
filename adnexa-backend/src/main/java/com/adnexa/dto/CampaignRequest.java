package com.adnexa.dto;

import lombok.Data;
import java.time.LocalDate;

@Data
public class CampaignRequest {
    private String title;
    private String description;
    private String category;
    private Double budget;
    private String platform;
    private LocalDate deadline;
}