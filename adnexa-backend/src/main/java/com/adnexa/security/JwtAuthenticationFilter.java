package com.adnexa.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	public JwtAuthenticationFilter(JwtUtil jwtUtil) {
		this.jwtUtil = jwtUtil;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		System.out.println("JWT FILTER EXECUTED");
		String authHeader = request.getHeader("Authorization");

		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			filterChain.doFilter(request, response);
			return;
		}

		String token = authHeader.substring(7);

		if (jwtUtil.validateToken(token) && SecurityContextHolder.getContext().getAuthentication() == null) {

		    String email = jwtUtil.extractEmail(token);
		    String role = jwtUtil.extractRole(token);

		    System.out.println("ROLE FROM TOKEN: " + role);

		    SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);

		    UsernamePasswordAuthenticationToken authentication =
		            new UsernamePasswordAuthenticationToken(
		                    email,
		                    null,
		                    List.of(authority)
		            );

		    System.out.println("Authorities: " + authentication.getAuthorities());

		    authentication.setDetails(
		            new WebAuthenticationDetailsSource().buildDetails(request)
		    );

		    SecurityContextHolder.getContext().setAuthentication(authentication);
		}

		filterChain.doFilter(request, response);
	}
}