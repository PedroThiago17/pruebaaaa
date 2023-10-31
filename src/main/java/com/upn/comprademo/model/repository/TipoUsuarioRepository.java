package com.upn.comprademo.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.upn.comprademo.model.entity.TipoUsuario;

public interface TipoUsuarioRepository extends JpaRepository<TipoUsuario, Long> {

}
