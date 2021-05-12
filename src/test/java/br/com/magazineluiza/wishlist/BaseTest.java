package br.com.magazineluiza.wishlist;

import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;
import br.com.magazineluiza.wishlist.domain.repository.ClienteRepository;

@SpringBootTest
@AutoConfigureMockMvc
public abstract class BaseTest {
    @BeforeEach
    public void setup(){
        Cliente cliente = new ClienteBuilder().defaultValues();
        clienteRepository.save(cliente);
    }

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ClienteRepository clienteRepository;
}
