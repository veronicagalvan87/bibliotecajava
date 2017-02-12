package org.empleodigital.controller;

import javax.validation.Valid;

import org.empleodigital.domain.entity.Usuario;
import org.empleodigital.domain.repository.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/")
public class UsuarioController {
	
	@Autowired
	private UsuarioRepositorio repoUsu;
	
	@RequestMapping(method = RequestMethod.GET,value={"/login","/"})
	public String loginInicio(Model model) {
		
		return "index";
	}
	
	@RequestMapping(method = RequestMethod.POST,value={"/login","/"})
	public String loginInicio(Model model,  @Valid @ModelAttribute Usuario per,BindingResult bindingResult) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		per.setContrasena(encoder.encode(per.getContrasena()));
		repoUsu.save(per);
		model.addAttribute("Mensaje", "Se ha registrado correctamente");
		return "index";
	}
	
	
}