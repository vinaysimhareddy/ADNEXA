package com.adnexa.dto;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApplicationResponse {

    private Long applicationId;

    private String influencerName;

    private String influencerEmail;

    private String message;

    private String status;

    private LocalDateTime appliedAt;
}