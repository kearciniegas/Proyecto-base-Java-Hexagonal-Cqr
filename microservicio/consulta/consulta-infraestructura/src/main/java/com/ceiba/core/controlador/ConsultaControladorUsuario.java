package com.ceiba.core.controlador;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.core.manejador.ManejadorListarUsuarios;
import com.ceiba.core.modelo.DtoUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios") 
@Api(tags={"Controlador consulta usuario"}) 
public class ConsultaControladorUsuario {

	private final ManejadorListarUsuarios manejadorListarUsuarios;

	public ConsultaControladorUsuario(ManejadorListarUsuarios manejadorListarUsuarios) {
		this.manejadorListarUsuarios = manejadorListarUsuarios;
	}

	@GetMapping
	@ApiOperation("Listar Usuarios")
	public List<DtoUsuario> listar() {
		return this.manejadorListarUsuarios.ejecutar();
	}

}
