package com.avaliacao.questaoProva.controllers;

import com.avaliacao.questaoProva.models.ContatosModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ContatosControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ContatosController controller;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @Test
    @DisplayName("Deve retornar 422 quando criar contato com email existente")
    public void deveRetornar422_QuandoCriarContatoComEmailExistente() throws Exception {
        ContatosModel contatoExistente = new ContatosModel(1L, "nomeTest1", "telefoneTest", "emailTest");
        ContatosModel contatos = new ContatosModel(1L, "nomeTest1", "telefoneTest1", "emailTest");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(contatoExistente);
        String json2 = mapper.writeValueAsString(contatos);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contatos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contatos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

    @Test
    @DisplayName("Deve retornar 422 quando criar contato com telefone existente")
    public void deveRetornar422_QuandoCriarContatoComTelefoneExistente() throws Exception {
        ContatosModel contatoExistente = new ContatosModel(2L, "nomeTest", "telefoneTest", "emailTest");
        ContatosModel contatos = new ContatosModel(2L, "nomeTest1", "telefoneTest", "emailTest1");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(contatoExistente);
        String json2 = mapper.writeValueAsString(contatos);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contatos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contatos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json))
                .andExpect(MockMvcResultMatchers.status().isUnprocessableEntity());
    }

    @Test
    @DisplayName("Deve retornar 200 quando buscar contato existente")
    public void deveRetornar200_QuandoBuscarContatoExistente() throws Exception {
        ContatosModel contatos = new ContatosModel(1L,"nomeTest1", "telefoneTest", "emailTest");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(contatos);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/contatos")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json));

        this.mockMvc.perform(MockMvcRequestBuilders.get("/contatos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}
