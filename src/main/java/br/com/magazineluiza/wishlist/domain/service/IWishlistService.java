package br.com.magazineluiza.wishlist.domain.service;

import java.util.Set;

import br.com.magazineluiza.wishlist.domain.entity.Produto;

public interface IWishlistService {
    Object Create (Long idCliente, Set<Long> idProdutos) throws Exception;
    Set<Produto> GetProdutosByIdCliente (Long idCliente);
    Produto GetProdutoByIdProduto (Long idCliente, Long idProdutos);
}