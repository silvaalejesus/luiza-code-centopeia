package br.com.magazineluiza.wishlist.service;

import br.com.magazineluiza.wishlist.BaseTest;
import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;
import br.com.magazineluiza.wishlist.domain.repository.ClienteRepository;

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
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.fasterxml.jackson.databind.introspect.TypeResolutionContext.Empty;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("service")
public class ClienteServiceTest extends BaseTest {
    @MockBean
    private ClienteRepository _clienteRepository;

    @InjectMocks
    private ClienteBuilder _clienteBuilder;

    @InjectMocks
    private ClienteService _clienteService;

    @Test
    @DisplayName("Test Create Cliente Return Success")
    public void CreateClienteReturnSuccess() {
        Cliente cliente = _clienteBuilder.defaultValues();
        when(_clienteRepository.save(any(Cliente.class))).thenReturn(cliente);
        Cliente created = _clienteService.Create(cliente);
        assertEquals(created.getNome(), cliente.getNome());
        assertEquals(created.getSobrenome(), cliente.getSobrenome());
        assertEquals(created.getCpf(), cliente.getCpf());
    }

    @Test
    @DisplayName("Test GetById Return Success")
    public void getById() {
        Cliente cliente = _clienteBuilder.defaultValues();
        when(_clienteRepository.findById(any(Long.class))).thenReturn(Optional.of(cliente));
        Cliente _cliente = _clienteService.GetById(cliente.getId());
        assertEquals(_cliente.getId(), cliente.getId());
        assertEquals(_cliente.getNome(), cliente.getNome());
        assertEquals(_cliente.getSobrenome(), cliente.getSobrenome());
        assertEquals(_cliente.getCpf(), cliente.getCpf());
    }

    // @Test
    // @DisplayName("Test GetById Return null")
    // public void getByIdReturnNull() {
    //     Cliente cliente = _clienteBuilder.defaultValues();
    //     when(_clienteRepository.findById(any(Long.class))).thenReturn(Optional.of(null));
    //     Cliente _cliente = _clienteService.GetById(cliente.getId());
    //     assertEquals(_cliente, null);
    // }

}