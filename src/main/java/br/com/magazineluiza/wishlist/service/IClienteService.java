package br.com.magazineluiza.wishlist.service;

import br.com.magazineluiza.wishlist.domain.entity.Cliente;

public interface IClienteService {
    Cliente GetById(Long id);
    Cliente GetByCpf(String cpf);
    Cliente Create (Cliente cliente);
    Cliente Update (Long id, Cliente cliente);
    Boolean Delete (Long id);
}