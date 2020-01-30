package com.ceiba.core.servicio.usuario;

import org.junit.Test;
import org.mockito.Mockito;

import com.ceiba.core.BasePrueba;
import com.ceiba.core.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.core.dominio.excepcion.ExcepcionLongitudValor;
import com.ceiba.core.modelo.usuario.Usuario;
import com.ceiba.core.repositorio.RepositorioUsuario;
import com.ceiba.core.servicio.testdatabuilder.UsuarioTestDataBuilder;

public class ServicioCrearUsuarioTest {

	@Test
    public void validarClaveLongitudMenor4Test() {
        // arrange
    	UsuarioTestDataBuilder usuarioTestDataBuilder = new UsuarioTestDataBuilder().conClave("124");
        // act - assert
        BasePrueba.assertThrows(() -> usuarioTestDataBuilder.build(), ExcepcionLongitudValor.class, "La clave debe tener una longitud mayor o igual a 4");
    }
	
	@Test
    public void validarUsuarioExistenciaPreviaTest() {
        // arrange
    	Usuario usuario = new UsuarioTestDataBuilder().build();
    	RepositorioUsuario repositorioUsuario = Mockito.mock(RepositorioUsuario.class);
    	Mockito.when(repositorioUsuario.existe(Mockito.anyString())).thenReturn(true);
    	ServicioCrearUsuario servicioCrearUsuario = new ServicioCrearUsuario(repositorioUsuario);
        // act - assert
        BasePrueba.assertThrows(() -> servicioCrearUsuario.ejecutar(usuario), ExcepcionDuplicidad.class,"El usuario ya existe en el sistema");
    }
}
