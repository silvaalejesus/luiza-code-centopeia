package br.com.magazineluiza.wishlist.domain.entity;

public class ProdutoBuilder {
    public Produto defaultValues(){
        return new Produto(1L,"Geladeira","Eletromóveis",1.500,"Branca");
    }
}
