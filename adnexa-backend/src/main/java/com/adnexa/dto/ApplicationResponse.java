package com.adnexa.dto;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDateTime;

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