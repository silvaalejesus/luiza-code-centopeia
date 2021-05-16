package br.com.magazineluiza.wishlist.service;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import br.com.magazineluiza.wishlist.BaseTest;
import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;
import br.com.magazineluiza.wishlist.domain.repository.ClienteRepository;
import br.com.magazineluiza.wishlist.domain.service.ClienteService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("service")
public class ClienteServiceTest extends BaseTest {
    @InjectMocks
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteBuilder clienteBuilder;

    @MockBean
    private ClienteService _clienteService;

    @Test
    @DisplayName("Test Create Cliente Return Success")
    public void CreateClienteReturnSuccess(){
        Cliente cliente = clienteBuilder.defaultValues();
        when(clienteRepository.save(any(Cliente.class))).thenReturn(new Cliente());
        Cliente created = _clienteService.Create(cliente);
        assertEquals(created.getNome(),cliente.getNome());
        assertEquals(created.getSobrenome(),cliente.getSobrenome());
        assertEquals(created.getCpf(),cliente.getCpf());
    }
    @Test
    @DisplayName("Test GetById Return Success")
    public void getById(){
        Cliente cliente = clienteBuilder.defaultValues();
        when(clienteRepository.findById(cliente.getId())).thenReturn(Optional.of(cliente));
        Cliente _cliente = _clienteService.GetById(cliente.getId());
        assertEquals(_cliente.getId(),cliente.getId());
    }

}