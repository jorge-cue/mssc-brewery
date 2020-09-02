package guru.springframework.msscbrewery.web.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static guru.springframework.msscbrewery.services.CustomerServiceImpl.TEST_CUSTOMER_ID;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * Created by jhcue on 02/09/2020
 */
@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void getCustomer_found() throws Exception {
        String customerId = TEST_CUSTOMER_ID;
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customer/{customerId}", customerId)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"customerId\":\"" + customerId + "\",\"name\":\"John Doe\"}"));
    }

    @Test
    void getCustomer_notFound() throws Exception {
        String customerId = UUID.randomUUID().toString();
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/customer/{customerId}", customerId)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}