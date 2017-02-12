package org.empleodigital.domain.repository;

import org.empleodigital.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface  UsuarioRepositorio extends JpaRepository<Usuario, Long> {

	UserDetails findByEmail(String email);
}
