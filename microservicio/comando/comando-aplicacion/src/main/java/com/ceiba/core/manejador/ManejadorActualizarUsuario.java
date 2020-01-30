package com.ceiba.core.manejador;

import org.springframework.stereotype.Component;

import com.ceiba.core.aplicacion.manejador.ManejadorComando;
import com.ceiba.core.comando.ComandoUsuario;
import com.ceiba.core.fabrica.FabricaUsuario;
import com.ceiba.core.modelo.usuario.Usuario;
import com.ceiba.core.servicio.usuario.ServicioActualizarUsuario;

@Component
public class ManejadorActualizarUsuario implements ManejadorComando<ComandoUsuario> {

	private final FabricaUsuario fabricaUsuario;
	private final ServicioActualizarUsuario servicioActualizarUsuario;

	public ManejadorActualizarUsuario(FabricaUsuario fabricaUsuario, ServicioActualizarUsuario servicioActualizarUsuario) {
		this.fabricaUsuario = fabricaUsuario;
		this.servicioActualizarUsuario = servicioActualizarUsuario;
	}

	public void ejecutar(ComandoUsuario comandoUsuario) {
		Usuario usuario = this.fabricaUsuario.crear(comandoUsuario);
		this.servicioActualizarUsuario.ejecutar(usuario);
	}
}
