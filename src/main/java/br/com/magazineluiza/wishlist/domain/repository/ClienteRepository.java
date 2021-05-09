package br.com.magazineluiza.wishlist.domain.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.magazineluiza.wishlist.domain.entity.Cliente;

public interface ClienteRepository extends CrudRepository<Cliente, Long> {

}
