package org.empleodigital.domain.propertyEditors;

import java.beans.PropertyEditorSupport;

import org.empleodigital.domain.entity.Autor;
import org.empleodigital.domain.repository.AutorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class AutorPropertyEditor extends PropertyEditorSupport {
	
	@Autowired
	private AutorRepositorio autorRepo;
	
	@Override
	public void setAsText(String text){
		long idAutor = Long.parseLong(text);
		Autor au= autorRepo.findOne(idAutor);
		setValue(au);
	}

}
