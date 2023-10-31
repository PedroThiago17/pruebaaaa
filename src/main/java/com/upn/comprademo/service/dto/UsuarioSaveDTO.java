package com.upn.comprademo.service.dto;

import java.io.Serializable;

public class UsuarioSaveDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nombre;
	private String apellidos;
	private Long tipoUsuario;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Long getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(Long tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
