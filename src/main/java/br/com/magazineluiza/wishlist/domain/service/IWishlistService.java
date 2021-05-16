package br.com.magazineluiza.wishlist.domain.service;

import java.util.Set;

public interface IWishlistService {
    Object Create (Long idCliente, Set<Long> idProdutos) throws Exception;
}