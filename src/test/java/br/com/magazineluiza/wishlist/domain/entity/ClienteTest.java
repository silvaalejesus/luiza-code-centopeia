package com.magazineluiza.wishlist.domain.entity;

import static org.assertj.core.api.Assertions.assertThat;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;

@SpringBootTest
public class ClienteTest {

   @Test
    public void criandoInstanciaCliente(){
        Cliente cliente = new ClienteBuilder().defaultValues();
        assertThat(cliente).isNotNull();
    }

}