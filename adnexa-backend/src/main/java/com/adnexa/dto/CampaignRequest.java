package com.adnexa.dto;

import java.time.LocalDate;
import lombok.Data;

@Data
public class CampaignRequest {

    private String title;

    private String description;

    private String category;

    private Double budget;

    private String platform;

    private LocalDate deadline;
}