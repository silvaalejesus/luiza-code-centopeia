package br.com.magazineluiza.wishlist.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import br.com.magazineluiza.wishlist.controllers.ClienteController;
import br.com.magazineluiza.wishlist.domain.service.ClienteService;

@SpringBootTest
public class ClienteControllerTest {
  @Autowired
  protected ClienteController clienteController;

  @Autowired
  protected ClienteService clienteService;
  

  @Test 
  public void cadastro(){

  }
}