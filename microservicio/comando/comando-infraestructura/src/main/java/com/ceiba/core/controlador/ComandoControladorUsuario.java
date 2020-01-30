package com.ceiba.core.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.comando.ComandoUsuario;
import com.ceiba.core.manejador.ManejadorActualizarUsuario;
import com.ceiba.core.manejador.ManejadorCrearUsuario;
import com.ceiba.core.manejador.ManejadorEliminarUsuario;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/usuarios")
@Api(tags = { "Controlador comando usuario"})
public class ComandoControladorUsuario {

	private final ManejadorCrearUsuario manejadorCrearUsuario;
	private final ManejadorEliminarUsuario manejadorEliminarUsuario;
	private final ManejadorActualizarUsuario manejadorActualizarUsuario;

	@Autowired
	public ComandoControladorUsuario(ManejadorCrearUsuario manejadorCrearUsuario,
			ManejadorEliminarUsuario manejadorEliminarUsuario,ManejadorActualizarUsuario manejadorActualizarUsuario) {
		this.manejadorCrearUsuario = manejadorCrearUsuario;
		this.manejadorEliminarUsuario = manejadorEliminarUsuario;
		this.manejadorActualizarUsuario = manejadorActualizarUsuario;
	}

	@PostMapping
	@ApiOperation("Crear Usuario")
	public ComandoRespuesta<Long> crear(@RequestBody ComandoUsuario comandoUsuario) {
		return manejadorCrearUsuario.ejecutar(comandoUsuario);
	}

	@DeleteMapping(value="/{id}")
	@ApiOperation("Eliminar Usuario")
	public void eliminar(@PathVariable Long id) {
		manejadorEliminarUsuario.ejecutar(id);
	}
	
	@PutMapping(value="/{id}")
	@ApiOperation("Actualizar Usuario")
	public void actualizar(@RequestBody ComandoUsuario comandoUsuario,@PathVariable Long id) {
		comandoUsuario.setId(id);
		manejadorActualizarUsuario.ejecutar(comandoUsuario);
	}
}
