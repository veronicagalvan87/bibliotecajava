package org.empleodigital.controller;

import javax.validation.Valid;

import org.empleodigital.domain.entity.Autor;
import org.empleodigital.domain.entity.Libro;
import org.empleodigital.domain.propertyEditors.AutorPropertyEditor;
import org.empleodigital.domain.repository.AutorRespositorio;
import org.empleodigital.domain.repository.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/libros")
public class LibroController {

	@Autowired
	private LibroRepositorio libroRepo;

	@Autowired
	private AutorRespositorio autorRepo;
	
	@Autowired
	private AutorPropertyEditor autorprop;

	@RequestMapping(method = RequestMethod.GET)
	public String listarLibros(Model model) {
		model.addAttribute("libros", libroRepo.findAll());
		model.addAttribute("autor", autorRepo.findAll());
		return "views/listadoLibros";

	}

	@RequestMapping(method = RequestMethod.POST)
	public String guardarLibros(Model model, @Valid @ModelAttribute Libro libros, BindingResult bindingResult) {
		libroRepo.save(libros);
		model.addAttribute("libros", libroRepo.findAll());
		model.addAttribute("autor", autorRepo.findAll());

		return "views/listadoLibros";

	}

	@RequestMapping(value = "/libro{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> borrar(Model model, @PathVariable Long id) {
		try {
			libroRepo.delete(id);
			return new ResponseEntity<String>(HttpStatus.OK);

		} catch (Exception ex) {
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
		}
	}
	 @InitBinder

     public void initBinder(WebDataBinder webDataBinder) {

         webDataBinder.registerCustomEditor(Autor.class, autorprop);

     }

     

     @RequestMapping(method=RequestMethod.GET, value="/{id}")

     @ResponseBody

     public Libro buscarAutor(@PathVariable Long id)

     {

         Libro li =libroRepo.findOne(id);

         return li;
}
}
