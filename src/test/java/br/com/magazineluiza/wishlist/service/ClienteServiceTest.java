package br.com.magazineluiza.wishlist.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;
import br.com.magazineluiza.wishlist.domain.repository.ClienteRepository;
import br.com.magazineluiza.wishlist.domain.service.ClienteService;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.Assert.assertEquals;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("service")
public class ClienteServiceTest {
    @InjectMocks
    private ClienteRepository clienteRepository;

    @InjectMocks
    private ClienteBuilder clienteBuilder;

    @MockBean
    private ClienteService _clienteService;

    @Test
    @DisplayName("Test Create Book Return Success")
    public void CreateClienteReturnSuccess(){
        Cliente cliente = clienteBuilder.defaultValues();
        when(clienteRepository.save(any(Cliente.class))).thenReturn(new Cliente());
        Cliente created = _clienteService.Create(cliente);
        assertEquals(created.getNome(),cliente.getNome());
        assertEquals(created.getSobrenome(),cliente.getSobrenome());
        assertEquals(created.getCpf(),cliente.getCpf());
    }

}