package com.techreturners.apilab1.controller;


import com.techreturners.apilab1.model.Coffee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@AutoConfigureMockMvc
@SpringBootTest
public class CoffeeControllerTests {
    @Autowired
    private MockMvc mockMvcController;

    @Test
    public void testGetCoffeeLover() throws Exception {
        String expectedContent = "I like coffee!";
        this.mockMvcController.perform(
                MockMvcRequestBuilders.get("/coffeelover"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetCoffeeLatte() throws Exception {
        String expectedContent = "latte";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name")
                .value(expectedContent));
    }

    @Test
    public void testGetCoffeeCapuccino() throws Exception {
        String expectedContent = "cappuccino";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee?name=cappuccino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name")
                .value(expectedContent));
    }

    @Test
    public void testGetCoffeeFlavourLatte() throws Exception {
        String expectedContent = "I like latte";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee flavour?name=latte"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }

    @Test
    public void testGetCoffeeFlavourCapuccino() throws Exception {
        String expectedContent = "I like cappuccino";
        this.mockMvcController.perform(
                        MockMvcRequestBuilders.get("/coffee flavour?name=cappuccino"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(expectedContent));
    }
}
