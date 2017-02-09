package org.empleodigital.controller;

import org.empleodigital.domain.entity.Autor;
import org.empleodigital.domain.entity.Prestamo;
import org.empleodigital.domain.repository.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/Prestamo")
public class PrestamoController {

	@Autowired
	private LibroRepositorio libroRepo;
	
	@RequestMapping(value="/Prestamo/{id}",method = RequestMethod.GET)
	public String mostrarPrestamos(Model model,@PathVariable Long id)
	{
		Prestamo.getOne(id);
		libroRepo.findAll();
		model.addAttribute("libros", libroRepo.findAll());
		model.addAttribute("autor", Autor.findAll());
		return "views/prestamos";
	}


}
