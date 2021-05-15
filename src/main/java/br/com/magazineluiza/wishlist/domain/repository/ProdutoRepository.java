package br.com.magazineluiza.wishlist.domain.repository;

import org.springframework.data.repository.CrudRepository;
import br.com.magazineluiza.wishlist.domain.entity.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {
    public List<Produto> findByName(String nome);
}

