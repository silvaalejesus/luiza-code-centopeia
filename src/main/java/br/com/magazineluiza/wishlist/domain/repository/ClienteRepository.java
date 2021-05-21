package br.com.magazineluiza.wishlist.domain.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import br.com.magazineluiza.wishlist.domain.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    Optional<Cliente> findByCpf(String cpf);
    public void deleteById(Long id);
}
