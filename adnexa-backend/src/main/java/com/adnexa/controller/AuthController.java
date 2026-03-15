package com.adnexa.controller;


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
	public String register(@RequestBody RegisterRequest request) {
		return userService.registerUser(request);
	}
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest request) {
		return userService.loginUser(request);
	}
	
	/*
	 * @GetMapping("/secure") public String secure() { return "JWT is working"; }
	 */
	
}
