package org.empleodigital.domain.repository;

import org.empleodigital.domain.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepositorio extends JpaRepository<Role, Long>{

}
