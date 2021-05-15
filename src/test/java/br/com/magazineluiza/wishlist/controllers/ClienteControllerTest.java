package br.com.magazineluiza.wishlist.controllers;

import br.com.magazineluiza.wishlist.BaseTest;
import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import br.com.magazineluiza.wishlist.domain.service.ClienteService;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;


@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("controller")
public class ClienteControllerTest extends BaseTest {
    @InjectMocks
    private ClienteController clienteController;

    @InjectMocks
    private ClienteBuilder clienteBuilder;

    @MockBean                          
    private ClienteService _clienteService;

    @Test
    @DisplayName("Test Create Book Return Success")
    public void CreateClienteReturnSuccess() throws Exception {
        String uri = "/cliente";
        Cliente cliente = clienteBuilder.defaultValues();

        when(_clienteService.Create(isA(Cliente.class)))
         .thenReturn(cliente);

        String inputJson = super.mapToJson(cliente);
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post(uri)
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .content(inputJson))
        .andReturn()
        .getResponse();

        assertEquals(response.getStatus(), HttpStatus.CREATED.value());
        // Cliente clienteResponse = mapFromJson(response.getContentAsString(), Cliente.class);
        // assertEquals(clienteResponse.getId(), cliente.getId());
        // assertEquals(clienteResponse.getNome(), cliente.getNome());
        // assertEquals(clienteResponse.getSobrenome(), cliente.getSobrenome());
        // assertEquals(clienteResponse.getCpf(), cliente.getCpf());
    } 
}