package com.adnexa.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/influencer")
public class InfluencerController {
	@PreAuthorize("hasRole('INFLUENCER')")
	@GetMapping("/dashboard")
	public String influencerDashboard() {
        return "Influencer Access";
    }

}
