package br.com.magazineluiza.wishlist.controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.service.ClienteService;

/**
 * ClienteController
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteService _clienteService;

    @RequestMapping(method = RequestMethod.POST)
    public Cliente Create(@RequestBody Cliente cliente) {
        return _clienteService.Create(cliente);
    }
}