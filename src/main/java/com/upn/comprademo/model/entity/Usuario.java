package com.upn.comprademo.model.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "USUARIOS")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name = "ID_USUARIO")
	private long idUsuario;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "APELLIDOS")
	private String apellidos;

	@JoinColumn(name = "ID_TIPO_USUARIO", referencedColumnName = "ID_TIPO_USUARIO")
	@ManyToOne(optional = false, fetch = FetchType.LAZY)
	private TipoUsuario tipoUsuario;
}
