package com.upn.comprademo.service;

import java.util.List;

import com.upn.comprademo.service.dto.UsuarioDTO;
import com.upn.comprademo.service.dto.UsuarioSaveDTO;

public interface IUsuarioService {

	List<UsuarioDTO> getAll();

	UsuarioDTO getById(long idUsuario);

	UsuarioDTO save(UsuarioSaveDTO usuario);

	UsuarioDTO update(UsuarioSaveDTO usuario);

	void delete(long idUsuario);
}
