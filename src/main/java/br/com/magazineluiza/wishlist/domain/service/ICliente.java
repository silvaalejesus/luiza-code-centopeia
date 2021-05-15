package br.com.magazineluiza.wishlist.domain.service;

import br.com.magazineluiza.wishlist.domain.entity.Cliente;

public interface ICliente {
    Cliente GetById(Long id);
    Cliente Create (Cliente cliente);
    Cliente Update (Long id, Cliente cliente);
    Boolean Delete (Long id);
}