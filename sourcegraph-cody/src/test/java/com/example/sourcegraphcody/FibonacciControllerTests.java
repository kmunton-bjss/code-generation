package com.example.sourcegraphcody;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

// Code generated by Cody chat with human intervention (converted junit4 to junit5, added package and imports)
@WebMvcTest(FibonacciController.class)
public class FibonacciControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(new FibonacciController()).build();
    }

    @Test
    public void testPositiveNumber() throws Exception {
        mockMvc.perform(get("/fibonacci?n=6"))
            .andExpect(status().isOk())
            .andExpect(content().json("[0,1,1,2,3,5]"));
    }

    @Test
    public void testNegativeNumber() throws Exception {
        mockMvc.perform(get("/fibonacci?n=-6"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testZero() throws Exception {
        mockMvc.perform(get("/fibonacci?n=0"))
            .andExpect(status().isBadRequest());
    }

    @Test
    public void testDefaultNumber() throws Exception {
        mockMvc.perform(get("/fibonacci"))
            .andExpect(status().isOk())
            .andExpect(content().json("[0,1,1,2,3]"));
    }

    // Test generated Cody autocomplete after method name written
    @Test
    public void testNumberHigherThan20() throws Exception {
        mockMvc.perform(get("/fibonacci?n=21"))
            .andExpect(status().isBadRequest());
    }

}
