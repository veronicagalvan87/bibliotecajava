package org.empleodigital.domain.repository;

import org.empleodigital.domain.entity.Autor;
import org.empleodigital.domain.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long>{
	
	Iterable<Libro> findAllByAutor(Autor au);


}
