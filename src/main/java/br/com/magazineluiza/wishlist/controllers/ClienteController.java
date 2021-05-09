package br.com.magazineluiza.wishlist.controllers;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    @PostMapping
    public  cadastro(){
        return "Hello World";
    }
}