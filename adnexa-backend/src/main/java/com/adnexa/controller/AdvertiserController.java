package com.adnexa.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advertiser")
public class AdvertiserController {
	 @PreAuthorize("hasRole('ADVERTISER')")
	 @GetMapping("/dashboard")
	 public String advertiserDashboard() {
	        return "Advertiser Access";
	    }

}
