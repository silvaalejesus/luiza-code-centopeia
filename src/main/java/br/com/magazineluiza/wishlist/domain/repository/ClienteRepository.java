package br.com.magazineluiza.wishlist.domain.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    public List<Cliente> findByName(String nome);
}