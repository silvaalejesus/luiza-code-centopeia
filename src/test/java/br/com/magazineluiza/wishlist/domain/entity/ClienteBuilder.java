package br.com.magazineluiza.wishlist.domain.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ClienteBuilder {

    public Cliente defaultValues(){
       Produto produto = new ProdutoBuilder().defaultValues();
       Set<Produto> produtos = new HashSet<>();
       produtos.add(produto);
        return new Cliente(1L,"Joao", "Ferreira","64195160057",produtos );
    }
}