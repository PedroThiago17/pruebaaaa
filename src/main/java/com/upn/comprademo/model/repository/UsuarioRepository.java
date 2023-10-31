package com.upn.comprademo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upn.comprademo.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
