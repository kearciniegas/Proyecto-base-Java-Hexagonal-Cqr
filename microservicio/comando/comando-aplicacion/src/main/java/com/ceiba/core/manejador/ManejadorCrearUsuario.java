package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.ComandoRespuesta;
import com.ceiba.core.aplicacion.manejador.ManejadorComandoRespuesta;
import com.ceiba.core.comando.ComandoUsuario;
import com.ceiba.core.fabrica.FabricaUsuario;
import com.ceiba.core.modelo.usuario.Usuario;
import com.ceiba.core.servicio.usuario.ServicioCrearUsuario;

@Component
public class ManejadorCrearUsuario implements ManejadorComandoRespuesta<ComandoUsuario, ComandoRespuesta<Long>> {

	private final FabricaUsuario fabricaUsuario;
	private final ServicioCrearUsuario servicioCrearUsuario;

	public ManejadorCrearUsuario(FabricaUsuario fabricaUsuario, ServicioCrearUsuario servicioCrearUsuario) {
		this.fabricaUsuario = fabricaUsuario;
		this.servicioCrearUsuario = servicioCrearUsuario;
	}

	public ComandoRespuesta<Long> ejecutar(ComandoUsuario comandoUsuario) {
		Usuario usuario = this.fabricaUsuario.crear(comandoUsuario);
		return new ComandoRespuesta<>(this.servicioCrearUsuario.ejecutar(usuario));
	}
}
