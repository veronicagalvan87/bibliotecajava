package org.empleodigital.domain.repository;

import org.empleodigital.domain.entity.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepositorio extends JpaRepository<Autor, Long> {

	Object findByNombreContaining(String name);

	Object findAllByNombreContaining(String name);
	

}
