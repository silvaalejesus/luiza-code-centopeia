package br.com.magazineluiza.wishlist.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ClienteTest {

   @Test
    public void criandoInstanciaCliente(){
        Cliente cliente = new ClienteBuilder().defaultValues();
        assertThat(cliente).isNotNull();
    }

}