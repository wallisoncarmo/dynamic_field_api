package com.carmowallison.dynamic_field_api.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.carmowallison.dynamic_field_api.security.UserSS;

public class UserSService {

	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
