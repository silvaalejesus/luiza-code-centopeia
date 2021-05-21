package br.com.magazineluiza.wishlist.service;

import java.util.Set;

import br.com.magazineluiza.wishlist.domain.entity.Produto;

public interface IWishlistService {
    Object Create (Long idCliente, Set<Long> idProdutos) throws Exception;
    Set<Produto> GetProdutosByIdCliente (Long idCliente);
    Produto GetProdutoByIdProduto (Long idCliente, Long idProdutos);
    Boolean Delete (Long idCliente, Long idProdutos);
    Boolean Insert (Long idCliente, Long idProdutos);
}