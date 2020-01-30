package com.ceiba.core.infraestructura.actuator;

import com.ceiba.core.infraestructura.excepcion.ExcepcionTecnica;//añadir

/**
 * Interface que tiene por objetivo ser implementada por todos los bloques 
 * que quieran utilizar HealthCheck
 * 
 * @author sergio.villamizar
 *
 */

public interface Salud  {//añadir
	/**
	 * Registra los bloques implementados
	 */
	public void registrarBloque();
	
	/**
	 * Valida la salud del bloque
	 * @throws ExepcionBloqueSinServicio
	 */
	public void verificar() throws ExcepcionTecnica;//añadir

}
