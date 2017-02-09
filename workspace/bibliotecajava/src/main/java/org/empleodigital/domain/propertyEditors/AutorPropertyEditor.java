package org.empleodigital.domain.propertyEditors;

import java.beans.PropertyEditorSupport;

import org.empleodigital.domain.entity.Autor;
import org.empleodigital.domain.repository.AutorRespositorio;
import org.springframework.beans.factory.annotation.Autowired;

public class AutorPropertyEditor extends PropertyEditorSupport {

    

    @Autowired

    private AutorRespositorio autorRepo;

    

    @Override

    public void setAsText(String text){

        long idAutor = Long.parseLong(text);

        Autor au= autorRepo.findOne(idAutor);

        setValue(au);

    }

}