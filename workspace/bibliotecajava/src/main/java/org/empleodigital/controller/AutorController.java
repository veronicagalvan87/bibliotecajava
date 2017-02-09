package org.empleodigital.controller;

import javax.validation.Valid;

import org.empleodigital.domain.entity.Autor;
import org.empleodigital.domain.entity.Libro;
import org.empleodigital.domain.repository.AutorRespositorio;
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

@Controller
@RequestMapping("/autores")
public class AutorController {
	@Autowired

	private LibroRepositorio libroRepo;

	@Autowired

	private AutorRespositorio autorRepo;

	@RequestMapping(method = RequestMethod.GET)

	public String listarAutores(Model model) {

		model.addAttribute("autores", autorRepo.findAll());

		return "views/listadoLibro";

	}

	@RequestMapping(value = "/autor/{id}", method = RequestMethod.GET)

	public String mostrarAutor(Model model, @PathVariable Long id) {

		Autor au = autorRepo.getOne(id);

		Iterable<Libro> li = libroRepo.findAllByAutor(au);

		model.addAttribute("autores", autorRepo.findAll());

		model.addAttribute("libros", li);

		model.addAttribute("autorUnico", autorRepo.findOne(id));

		return "views/listadoLibro";

	}

	@RequestMapping(method = RequestMethod.POST)

	public String guardarAutor(Model model, @Valid @ModelAttribute Autor au, BindingResult bindingResult) {

		autorRepo.save(au);

		model.addAttribute("autores", autorRepo.findAll());

		return "views/listadoLibro";

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
