package org.empleodigital.controller;

import org.empleodigital.domain.entity.Usuario;
import org.empleodigital.domain.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/index")
public class UsuarioController {
	@Autowired private UsuarioRepositorio usuariorep;

	@RequestMapping(method = RequestMethod.GET)
	public String usuario (Model model) {
		
	
		return "index";
		
	}
}
