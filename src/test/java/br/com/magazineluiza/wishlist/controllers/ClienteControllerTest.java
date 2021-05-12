package br.com.magazineluiza.wishlist.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;
import br.com.magazineluiza.wishlist.controllers.ClienteController;
import br.com.magazineluiza.wishlist.domain.service.ClienteService;

import static org.mockito.Mockito.when;

@SpringBootTest
public class ClienteControllerTest {
  @Autowired
  protected ClienteController clienteController;

  @MockBean
	private ClienteService service;

  @Autowired
  protected MockMvc mockMvc;

  
  @Test
	public void createShouldReturnCliente() throws Exception {
        Cliente cliente = new ClienteBuilder().defaultValues();
            when(service.Create(cliente)).thenReturn(cliente);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/cliente")
                  .contentType(MediaType.APPLICATION_JSON_VALUE)
                  .content(asJsonString(cliente)))
                  .andExpect(MockMvcResultMatchers.status().isOk());
	}

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}