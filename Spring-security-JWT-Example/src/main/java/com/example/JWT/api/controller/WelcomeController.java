package com.example.JWT.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.JWT.api.entity.AuthRequest;
import com.example.JWT.api.util.JwtUtils;

@RestController
public class WelcomeController {

	@Autowired
	private JwtUtils jwtUtil;
	@Autowired
	private AuthenticationManager authenticationManager;

	@GetMapping(value = "/")
	public String welcome() {
		return "Welcome To Spring Boot JWT Validations";
	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getName(), authRequest.getPassword()));
		} catch (Exception ex) {
			throw new Exception("inavalid username/password");
		}
		return jwtUtil.generateToken(authRequest.getName());
	}

}
