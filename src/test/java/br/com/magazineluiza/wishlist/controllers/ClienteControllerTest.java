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

import java.util.Optional;

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
    @DisplayName("Test Create Cliente Return Success")
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
        Cliente clienteResponse = mapFromJson(response.getContentAsString(), Cliente.class);
        assertEquals(clienteResponse.getId(), cliente.getId());
        assertEquals(clienteResponse.getNome(), cliente.getNome());
        assertEquals(clienteResponse.getSobrenome(), cliente.getSobrenome());
        assertEquals(clienteResponse.getCpf(), cliente.getCpf());
    }

    @Test
    @DisplayName("Test Buscar Cliente por Cpf Return Success")
    public void GetByCpfReturnSuccess() throws Exception {
        String uri = "/cliente/";
        Cliente cliente = clienteBuilder.defaultValues();

        when(_clienteService.GetByCpf(isA(String.class)))
                .thenReturn(cliente);

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get(uri,cliente.getCpf()))
            .andExpect(status().isOk())
            .andReturn(); 

        Cliente clienteResponse = mapFromJson(response.getContentAsString(), Cliente.class);
        assertEquals(clienteResponse.getId(), cliente.getId());
        assertEquals(clienteResponse.getNome(), cliente.getNome());
        assertEquals(clienteResponse.getSobrenome(), cliente.getSobrenome());
        assertEquals(clienteResponse.getCpf(), cliente.getCpf());
    }

    @Test
    @DisplayName("Test Buscar Cliente por Id Return Success")
    public void GetByIdSuccess() throws Exception {
        String uri = "/cliente/";
        Cliente cliente = clienteBuilder.defaultValues();

        when(_clienteService.GetById(isA(Long.class)))
            .thenReturn(cliente);

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.get(uri,cliente.getId()))
            .andExpect(status().isOk())
            .andReturn();   

        Cliente clienteResponse = mapFromJson(response.getContentAsString(), Cliente.class);
        assertEquals(clienteResponse.getId(), cliente.getId());
        assertEquals(clienteResponse.getNome(), cliente.getNome());
        assertEquals(clienteResponse.getSobrenome(), cliente.getSobrenome());
        assertEquals(clienteResponse.getCpf(), cliente.getCpf());
    }
    
    @Test
    @DisplayName("Test Delete Return Success")
    public void DeleteReturnSuccess() throws Exception {
        String uri = "/cliente/";
        Cliente cliente = clienteBuilder.defaultValues();

        when(_clienteService.Delete(isA(Long.class)))
                .thenReturn(true);

        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.delete(uri,cliente.getId())).andExpect(status().isOk()).andReturn();            
    }
}