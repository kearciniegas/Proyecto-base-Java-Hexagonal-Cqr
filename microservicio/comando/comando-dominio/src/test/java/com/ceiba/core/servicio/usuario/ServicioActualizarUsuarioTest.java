package com.ceiba.core.servicio.usuario;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.modelo.usuario.Usuario;
import com.ceiba.core.repositorio.RepositorioUsuario;
import com.ceiba.core.servicio.testdatabuilder.UsuarioTestDataBuilder;

public class ServicioActualizarUsuarioTest {
	
	@Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
    	Usuario usuario = new UsuarioTestDataBuilder().conId(1L).build();
    	RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
    	Mockito.when(repositorioUsuario.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
    	ServicioActualizarUsuario servicioActualizarUsuario = new ServicioActualizarUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }
}
