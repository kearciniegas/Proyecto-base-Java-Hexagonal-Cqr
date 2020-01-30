package com.ceiba.core.dao.usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

import org.springframework.jdbc.core.RowMapper;

import com.ceiba.core.infraestructura.jdbc.MapperResult;
import com.ceiba.core.modelo.DtoUsuario;

public class MapeoUsuario implements RowMapper<DtoUsuario>,MapperResult {

    @Override
    public DtoUsuario mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        
    	Long id = resultSet.getLong("id");
        String nombre = resultSet.getString("nombre");
        String clave = resultSet.getString("clave");
        LocalDateTime fecha = extraerLocalDateTime(resultSet, "fecha_creacion");

        return new DtoUsuario(id,nombre,clave,fecha);
    }

}
