package br.com.magazineluiza.wishlist.controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Cliente> Create(@RequestBody Cliente cliente) {
        Cliente result = _clienteService.Create(cliente);
        return new ResponseEntity<Cliente>(result, HttpStatus.CREATED);
    }
}