package com.ceiba.core.modelo;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoUsuario {

	private Long id;
    private String nombre;
    private String clave;
    private LocalDateTime fechaCreacion;
}
