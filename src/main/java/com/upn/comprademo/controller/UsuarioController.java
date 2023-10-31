package com.upn.comprademo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.upn.comprademo.service.IUsuarioService;
import com.upn.comprademo.service.dto.UsuarioDTO;
import com.upn.comprademo.service.dto.UsuarioSaveDTO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@CrossOrigin("*")
@RequestMapping("usuario")
@Api(tags = "UsuarioApi", value = "/usuario", description = "API para el mantenimiento de Usuario.")
public class UsuarioController {

	@Autowired
	private IUsuarioService usuarioService;

	@GetMapping(value = "/getAllUsuarios")
	@ApiOperation(value = "Obtiene todos los usuarios")
	@ApiResponses({ @ApiResponse(code = 400, message = "Petición incorrecta"),
			@ApiResponse(code = 401, message = "Acceso denegado"), @ApiResponse(code = 403, message = "Sin permisos"),
			@ApiResponse(code = 500, message = "Error del servidor :(") })
	public ResponseEntity<Object> getAllUsuarios() {
		try {
			final List<UsuarioDTO> response = this.usuarioService.getAll();

			if (response.isEmpty()) {
				return ResponseEntity.status(HttpStatus.NOT_FOUND).contentType(MediaType.APPLICATION_JSON)
						.body("No se encontraron datos");
			} else {
				return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(response);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
					.body(e.getLocalizedMessage());
		}

	}

	@PostMapping(value = "/saveUsuario")
	public ResponseEntity<Object> saveUsuario(@Validated @RequestBody UsuarioSaveDTO usuario) {
		try {
			final UsuarioDTO response = this.usuarioService.save(usuario);
			if (response != null) {
				return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(response);
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON)
						.body("Error al guardar usuario");
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).contentType(MediaType.APPLICATION_JSON)
					.body(e.getLocalizedMessage());
		}
	}

}
