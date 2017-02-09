package org.empleodigital.domain.service;

import org.empleodigital.domain.entity.Libro;
import org.empleodigital.domain.repository.LibroRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ServicioAutoidentificacion implements UserDetailsService {

	@Autowired
	private LibroRepositorio usuarioRepositorio;

	public Libro loadUserByUsername(Long login) throws UsernameNotFoundException {

		return usuarioRepositorio.findOne(login);

	}

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
