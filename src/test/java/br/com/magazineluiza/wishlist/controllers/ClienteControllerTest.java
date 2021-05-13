package br.com.magazineluiza.wishlist.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;
import br.com.magazineluiza.wishlist.controllers.ClienteController;
import br.com.magazineluiza.wishlist.domain.service.ClienteService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("controller")
public class ClienteControllerTest {
    @InjectMocks
    protected ClienteController clienteController;

    @Mock
    private ClienteService service;

    @Test
    @DisplayName("Test createShouldReturnCliente Success")
	public void createShouldReturnCliente() {
        Cliente cliente = new ClienteBuilder().defaultValues();
        
        when(service.Create(cliente)).thenReturn(cliente);
        Cliente result = clienteController.Create(cliente);
 
        assertEquals(cliente.getNome(), result.getNome());
        assertEquals(cliente.getSobrenome(), result.getSobrenome());
        assertEquals(cliente.getCpf(), result.getCpf());
	}

  
}