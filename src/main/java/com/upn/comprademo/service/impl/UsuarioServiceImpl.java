package com.upn.comprademo.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upn.comprademo.model.entity.TipoUsuario;
import com.upn.comprademo.model.entity.Usuario;
import com.upn.comprademo.model.repository.UsuarioRepository;
import com.upn.comprademo.service.IUsuarioService;
import com.upn.comprademo.service.dto.UsuarioDTO;
import com.upn.comprademo.service.dto.UsuarioSaveDTO;

@Service
@Transactional
public class UsuarioServiceImpl implements IUsuarioService {

	private ModelMapper mapper = new ModelMapper();

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public List<UsuarioDTO> getAll() {
		this.mapper.getConfiguration().setAmbiguityIgnored(true);
		System.out.println("Se van a listar todos los usuarios.");

		UsuarioDTO usuarioResponse;
		List<UsuarioDTO> response = new ArrayList<>();

		List<Usuario> usuariosModel = this.usuarioRepository.findAll();

		if (!usuariosModel.isEmpty()) {
			for (Usuario usuario : usuariosModel) {
				usuarioResponse = this.mapper.map(usuario, UsuarioDTO.class);
				usuarioResponse.setNombreRol(usuario.getTipoUsuario().getNombre());
				response.add(usuarioResponse);
			}
		}

		return response;
	}

	@Override
	public UsuarioDTO getById(long idUsuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UsuarioDTO save(UsuarioSaveDTO usuario) {
		this.mapper.getConfiguration().setAmbiguityIgnored(true);
		System.out.println("Se va guardar un nuevo usuario");

		Usuario usuarioModel = this.mapper.map(usuario, Usuario.class);

		TipoUsuario tipoUsuario = new TipoUsuario();
		tipoUsuario.setIdTipoUsuario(usuario.getTipoUsuario());

		usuarioModel.setTipoUsuario(tipoUsuario);

		usuarioModel = this.usuarioRepository.save(usuarioModel);

		UsuarioDTO response = this.mapper.map(usuarioModel, UsuarioDTO.class);
		response.setNombreRol(usuarioModel.getTipoUsuario().getNombre());

		return response;
	}

	@Override
	public UsuarioDTO update(UsuarioSaveDTO usuario) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(long idUsuario) {
		// TODO Auto-generated method stub

	}

}
