package br.com.magazineluiza.wishlist.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.repository.ClienteRepository;

@Service
public class ClienteService implements ICliente {
    @Autowired
    private ClienteRepository _clienteRepository;

    @Override
    public Cliente GetById(Long id) {
        Optional<Cliente> cliente = _clienteRepository.findById(id);
        if (cliente.isPresent()) {
            return cliente.get();
        }
        return null;
    }

    @Override
    public Cliente Create(Cliente cliente) {
        return _clienteRepository.save(cliente);
    }
}