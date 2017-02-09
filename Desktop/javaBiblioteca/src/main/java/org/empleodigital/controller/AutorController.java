package org.empleodigital.controller;

import javax.validation.Valid;

import org.empleodigital.domain.entity.Autor;
import org.empleodigital.domain.entity.Libro;
import org.empleodigital.domain.repository.AutorRepositorio;
import org.empleodigital.domain.repository.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/autores")
public class AutorController {

	@Autowired
	private LibroRepositorio libroRepo;

	@Autowired
	private AutorRepositorio autorRepo;

	@RequestMapping(method = RequestMethod.GET)
	public String ProstitutaInTheHeaven(Model model) {

		model.addAttribute("autores", autorRepo.findAll());

		return "views/listadoAutores";
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody 
	public Autor mostrarAutor( @PathVariable Long id) {
		Autor au = autorRepo.findOne(id);


		return au;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardarAutor(Model model, @Valid @ModelAttribute Autor au, BindingResult bindingResult) {
		autorRepo.save(au);
		model.addAttribute("autores", autorRepo.findAll());
		return "views/listadoAutores";
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> borrar(@PathVariable Long id) {
		try {
			autorRepo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}

}
