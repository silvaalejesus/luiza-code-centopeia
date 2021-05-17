package br.com.magazineluiza.wishlist.domain.entity;

import java.util.Set;

public class ClienteBuilder {

    public Cliente defaultValues(){
       Produto produto = new ProdutoBuilder().defaultValues();
        return new Cliente(1L,"Joao", "Ferreira","64195160057", (Set<Produto>) produto);
    }
}