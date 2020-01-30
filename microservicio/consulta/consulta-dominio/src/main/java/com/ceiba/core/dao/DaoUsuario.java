package com.ceiba.core.dao;

import java.util.List;

import com.ceiba.core.modelo.DtoUsuario;

public interface DaoUsuario {

	/**
	 * Permite listar usuarios
	 * @return los usuarios
	 */
	List<DtoUsuario> listar();

}