package br.com.magazineluiza.wishlist.controllers;
import java.util.List;
import java.util.ArrayList;



public class ConsultarProduto {

    //criar uma lista de produtos
    //buscar produto dentro da lista
    //caso produto esteja na lista exibir mensagem:"produto ja está adicionado"
    //caso produto não esteja na lista, adicionar.

    public static void main(String[] args) {

        String produto1 = "produto1";
        String produto2 = "produto2";
        String produto3 = "produto3";

        ArrayList<String> produtos = new ArrayList<>();
        produtos.add(produto1);
        produtos.add(produto2);
        produtos.add(produto3);

        System.out.println(produtos);
    }

}