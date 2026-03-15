package com.adnexa.dto;

import com.adnexa.enums.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterRequest {
	private String name;
	private String email;
	private String password;
	private Role role;
}
