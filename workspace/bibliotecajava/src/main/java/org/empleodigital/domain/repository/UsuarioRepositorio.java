package org.empleodigital.domain.repository;

import org.empleodigital.domain.entity.Libro;

import org.springframework.data.repository.CrudRepository;

import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepositorio extends CrudRepository<Libro, Long> {

    public default UserDetails findOneByLogin(String login) {

        // TODO Auto-generated method stub

        return null;

    }

}
