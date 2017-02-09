package org.empleodigital.controller;

import javax.validation.Valid;

import org.empleodigital.domain.entity.Autor;
import org.empleodigital.domain.entity.Libro;
import org.empleodigital.domain.propertyEditors.AutorPropertyEditor;
import org.empleodigital.domain.repository.AutorRepositorio;
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
		private AutorRepositorio autorRepo;
		
		@Autowired 
		private AutorPropertyEditor autorprop;
		

		@RequestMapping(method = RequestMethod.GET)
		public String listarLibros(Model model) {
			
			model.addAttribute("libros",libroRepo.findAll());
			model.addAllAttributes(autorRepo.findAll());
			return "views/listadoLibro";
		}
		
		@RequestMapping(method=RequestMethod.POST)
		public String guardarLibros(Model model, @Valid @ModelAttribute Libro li,BindingResult bindingResult){
			
			libroRepo.save(li);
			model.addAttribute("libros",libroRepo.findAll());
			model.addAttribute("autores", autorRepo.findAll());
			
			return "views/listadoLibro";
			
		}
		
		@RequestMapping(value="/libro/{id}",method = RequestMethod.GET)
		public String mostrarLibros(Model model,@PathVariable Long id)
		{
			model.addAttribute("libroUnico",libroRepo.findOne(id));
			return "views/listadoLibro";
		}
		
		@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
		public ResponseEntity<String> borrar(@PathVariable Long id)
		{
			try {
				libroRepo.delete(id);
				return new ResponseEntity<String>(HttpStatus.OK);
			} catch (Exception e) {
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
