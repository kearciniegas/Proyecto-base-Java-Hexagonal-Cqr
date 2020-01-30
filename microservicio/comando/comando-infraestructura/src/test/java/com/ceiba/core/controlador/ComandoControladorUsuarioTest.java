package com.ceiba.core.controlador;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.ceiba.core.ApplicationMock;
import com.ceiba.core.comando.ComandoUsuario;
import com.ceiba.core.testdatabuilder.ComandoUsuarioTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=ApplicationMock.class)
@WebMvcTest(ComandoControladorUsuario.class)
public class ComandoControladorUsuarioTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;
    
    

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoUsuario usuario = new ComandoUsuarioTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(usuario)))
        		.andExpect(status().isOk())
        		.andExpect(content().json("{'valor': 1}"));
    }
    
    @Test
    public void actualizar() throws Exception{
        // arrange
    	Long id = 1L;
        ComandoUsuario usuario = new ComandoUsuarioTestDataBuilder().build();

        // act - assert
        mocMvc.perform(put("/usuarios/{id}",id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(usuario)))
        		.andExpect(status().isOk());
    }
    
    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 1L;

        // act - assert
        mocMvc.perform(delete("/usuarios/{id}",id)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
