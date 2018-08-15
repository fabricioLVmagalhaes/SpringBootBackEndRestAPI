package com.fabriciomagalhaes.cursomc.services;

import org.springframework.security.core.context.SecurityContextHolder;

import com.fabriciomagalhaes.cursomc.security.UserSS;

public class UserService {

	//metodo para retornar usuário logado
	public static UserSS authenticated() {
		try {
			return (UserSS) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {

			return null;

		}

	}

}
