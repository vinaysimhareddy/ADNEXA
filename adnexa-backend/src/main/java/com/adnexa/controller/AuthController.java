package com.adnexa.controller;


import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adnexa.dto.LoginRequest;
import com.adnexa.dto.RegisterRequest;
import com.adnexa.service.UserService;
@RestController
@RequestMapping("/api/auth")
public class AuthController {
	private final UserService userService;
	public AuthController(UserService userService) {
		this.userService=userService;
	}
	
	@PostMapping("/register")
	public ResponseEntity<Map<String, String>> register(@RequestBody RegisterRequest request) {
	    String result = userService.registerUser(request);
	    return ResponseEntity.ok(Map.of("message", result));
	}

	@PostMapping("/login")
	public ResponseEntity<Map<String, String>> login(@RequestBody LoginRequest request) {
	    String token = userService.loginUser(request);
	    return ResponseEntity.ok(Map.of("token", token));
	}
	
}
