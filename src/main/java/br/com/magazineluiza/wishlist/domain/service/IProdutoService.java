package br.com.magazineluiza.wishlist.domain.service;

import br.com.magazineluiza.wishlist.domain.entity.Produto;

public interface IProdutoService {
    Iterable<Produto> GetAll();
    Produto GetById(Long id);
    Produto Create (Produto produto);
    Produto Update (Long id, Produto produto);
    Boolean Delete (Long id);
}