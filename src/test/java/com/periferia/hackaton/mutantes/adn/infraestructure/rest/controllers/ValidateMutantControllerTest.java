package com.periferia.hackaton.mutantes.adn.infraestructure.rest.controllers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.periferia.hackaton.mutantes.adn.application.usescases.SaveAdn;
import com.periferia.hackaton.mutantes.adn.infraestructure.rest.dto.request.RequestAdn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
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
public class ValidateMutantControllerTest {

    @Mock
    private WebApplicationContext wac;

    @InjectMocks
    private ValidateMutantController validateMutantController;

    @Mock
    SaveAdn saveAdn;

    private MockMvc mockMvc;

    @BeforeEach
    void init(){
        mockMvc = MockMvcBuilders.standaloneSetup(validateMutantController).build();
    }

    @Test
    void mutant() throws Exception {
        String[] chains = new String[]{
                "AGAGAG", "AACTCG", "TCTGTA", "TGAATA", "CGGTCC", "ACAGTC"
        };
        RequestAdn dna = new RequestAdn();
        dna.setDna(chains);
        ArgumentCaptor<String[]> valueCapture = ArgumentCaptor.forClass(String[].class);
        Mockito.doNothing().when(saveAdn).execute(valueCapture.capture());
        saveAdn.execute(chains);
        mockMvc.perform(MockMvcRequestBuilders
                        .post("http://localhost:8080/adn/mutant")
                        .content(asJsonString(dna))
                        .characterEncoding("utf-8")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isForbidden());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
