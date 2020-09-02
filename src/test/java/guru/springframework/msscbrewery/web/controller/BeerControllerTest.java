package guru.springframework.msscbrewery.web.controller;

import guru.springframework.msscbrewery.services.BeerService;
import guru.springframework.msscbrewery.services.BeerServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrint;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static guru.springframework.msscbrewery.services.BeerServiceImpl.TEST_BEER_ID;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/*
 * Created by jhcue on 02/09/2020
 */
@SpringBootTest
@AutoConfigureMockMvc(print = MockMvcPrint.LOG_DEBUG)
class BeerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetBeer_found() throws Exception {
        final String beerId = TEST_BEER_ID;
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/beer/{beerId}", beerId)
                .accept(MediaType.APPLICATION_JSON)
        )
        .andDo(print())
        .andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect((content().json("{\"beerId\":\"" + beerId + "\",\"beerName\":\"Galaxy Cat\",\"beerStyle\":\"Lager\",\"upc\":12345}")))
        ;
    }

    @Test
    void testGetBeer_notFound() throws Exception {
        String beerId = UUID.randomUUID().toString();
        mockMvc.perform(
                MockMvcRequestBuilders.get("/api/v1/beer/{beerId}", beerId)
                        .accept(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isNotFound());
        ;
    }
}