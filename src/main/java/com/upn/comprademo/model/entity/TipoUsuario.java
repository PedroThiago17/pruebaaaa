package com.upn.comprademo.model.entity;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TIPO_USUARIO")
public class TipoUsuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_TIPO_USUARIO")
	private long idTipoUsuario;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "DESCRIPCION")
	private String descripcion;

	@OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
	private List<Usuario> usuarios;

	public long getIdTipoUsuario() {
		return idTipoUsuario;
	}

	public void setIdTipoUsuario(long idTipoUsuario) {
		this.idTipoUsuario = idTipoUsuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
