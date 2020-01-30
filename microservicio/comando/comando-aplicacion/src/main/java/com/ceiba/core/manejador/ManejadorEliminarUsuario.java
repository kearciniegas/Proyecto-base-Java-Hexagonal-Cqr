package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.servicio.usuario.ServicioEliminarUsuario;

@Component
public class ManejadorEliminarUsuario implements ManejadorComando<Long> {

	private final ServicioEliminarUsuario servicioEliminarUsuario;

	public ManejadorEliminarUsuario(ServicioEliminarUsuario servicioEliminarUsuario) {
		this.servicioEliminarUsuario = servicioEliminarUsuario;
	}

	public void ejecutar(Long idUsuario) {
		this.servicioEliminarUsuario.ejecutar(idUsuario);

	}
}
