package com.adnexa.dto;

import lombok.Data;

@Data
public class ApplyCampaignRequest {

    private Long campaignId;

    private String message;
}