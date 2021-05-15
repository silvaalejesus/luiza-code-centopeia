package br.com.magazineluiza.wishlist.domain.service;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magazineluiza.wishlist.domain.entity.Produto;
import br.com.magazineluiza.wishlist.domain.repository.ProdutoRepository;

@Service
public class ProdutoService implements IProduto {
    @Autowired
    private ProdutoRepository _produtoRepository;

    @Override
    public Produto GetById(Long id) {
        Optional<Produto> produto = _produtoRepository.findById(id);
        if (produto.isPresent()) {
            return produto.get();
        }
        return null;
    }

    @Override
    public Produto Create(Produto produto) {
        return _produtoRepository.save(produto);
    }
}