package com.example.ghcopilot;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ExtendWith(MockitoExtension.class)
public class CalculatorControllerTest {

    private MockMvc mockMvc;

    @Mock
    private CalculatorService calculatorService;

    @BeforeEach
    public void setup() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new CalculatorController(calculatorService)).build();
    }

    @Test
    private void add_success() throws Exception {
        when(calculatorService.add(2, 3)).thenReturn(5);
        this.mockMvc.perform(get("/add?first=2&second=3")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"answer\":  5}"));
    }

    @Test
    private void add_negativeNumbers_success() throws Exception {
        when(calculatorService.add(-1, -3)).thenReturn(-4);
        this.mockMvc.perform(get("/add?first=-1&second=-3")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"answer\":  -4}"));
    }

    @Test
    private void add_noNumbers_error() throws Exception {
        this.mockMvc.perform(get("/add?first=&second=")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    private void add_noQueryParams_error() throws Exception {
        this.mockMvc.perform(get("/add")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    private void substract_success() throws Exception {
        when(calculatorService.subtract(5, 2)).thenReturn(3);
        this.mockMvc.perform(get("/subtract?first=5&second=2")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"answer\":  3}"));
    }

    @Test
    private void substract_negativeNumbers_success() throws Exception {
        when(calculatorService.subtract(-5, -2)).thenReturn(-3);
        this.mockMvc.perform(get("/subtract?first=-5&second=-2")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"answer\":  -3}"));
    }

    @Test
    private void subtract_noNumbers_error() throws Exception {
        this.mockMvc.perform(get("/subtract?first=&second=")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    private void subtract_noQueryParams_error() throws Exception {
        this.mockMvc.perform(get("/subtract")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    private void multiply_success() throws Exception {
        when(calculatorService.multiply(2, 3)).thenReturn(6);
        this.mockMvc.perform(get("/multiply?first=2&second=3")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"answer\":  6}"));
    }

    @Test
    private void multiply_negativeNumbers_success() throws Exception {
        when(calculatorService.multiply(-2, -3)).thenReturn(6);
        this.mockMvc.perform(get("/multiply?first=-2&second=-3")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"answer\":  6}"));
    }

    @Test
    private void multiply_noNumbers_error() throws Exception {
        this.mockMvc.perform(get("/multiply?first=&second=")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    private void multiply_noQueryParams_error() throws Exception {
        this.mockMvc.perform(get("/multiply")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    private void divide_success() throws Exception {
        when(calculatorService.divide(4, 2)).thenReturn(2);
        this.mockMvc.perform(get("/divide?first=4&second=2")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"answer\":  2}"));
    }

    @Test
    private void divide_negativeNumbers_success() throws Exception {
        when(calculatorService.divide(-4, -2)).thenReturn(2);
        this.mockMvc.perform(get("/divide?first=-4&second=-2")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(content().json("{\"answer\":  2}"));
    }

    @Test
    private void divide_noNumbers_error() throws Exception {
        this.mockMvc.perform(get("/divide?first=&second=")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    private void divide_noQueryParams_error() throws Exception {
        this.mockMvc.perform(get("/divide")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }

    @Test
    private void divide_byZero_error() throws Exception {
        this.mockMvc.perform(get("/divide?first=4&second=0")
                .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isBadRequest());
    }




    }
