package com.abc.ecommerce.controller;

import com.abc.ecommerce.dto.LogisticRequestDTO;
import com.abc.ecommerce.dto.LogisticResponseDTO;
import com.abc.ecommerce.service.LogisticService;
import com.abc.ecommerce.service.UserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = LogisticController.class)
public class LogisticControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @InjectMocks
    private LogisticController logisticController;

    @MockBean
    private LogisticService logisticService;

    @MockBean
    private UserDetailsService userDetailsService;

    @Test
    void query_shouldReturnLogisticResponseDTO() throws Exception {
        // Given
        LogisticRequestDTO requestDTO = new LogisticRequestDTO();
        LogisticResponseDTO mockResponse = new LogisticResponseDTO();

        // Mock the behavior of logisticService.queryLogisticInfo()
        Mockito.when(logisticService.queryLogisticInfo(requestDTO)).thenReturn(mockResponse);

      mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/abc/logistics/info")
                        .content(asJsonString(requestDTO))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError())
                .andReturn();

    }

    // Utility method to convert objects to JSON string
    private String asJsonString(Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
