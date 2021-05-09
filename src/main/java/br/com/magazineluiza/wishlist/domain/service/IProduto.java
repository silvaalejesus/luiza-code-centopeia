package br.com.magazineluiza.wishlist.domain.service;

import br.com.magazineluiza.wishlist.domain.entity.Produto;

public interface IProduto {
    Produto GetById(Long id);
    Produto Create (Produto produto);
}