package com.periferia.hackaton.mutantes.adn.infraestructure.rest.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.periferia.hackaton.mutantes.adn.application.usescases.StatisticsAdn;
import com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.request.RequestAdn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
public class StatisticsControllerTest {

    @Mock
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Mock
    private StatisticsAdn statisticsAdn;

    @InjectMocks
    private StatisticsController statisticsController;

    @BeforeEach
    void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(statisticsController).build();
    }

    @Test
    void mutant() throws Exception {
        Mockito.doNothing().when(statisticsAdn).execute();
        mockMvc.perform(MockMvcRequestBuilders
                        .get("http://localhost:8080/adn/stats")
                        .characterEncoding("utf-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
