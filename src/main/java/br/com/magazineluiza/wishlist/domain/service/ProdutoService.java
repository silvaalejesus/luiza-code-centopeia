package br.com.magazineluiza.wishlist.domain.service;

import java.util.Optional;

import org.hibernate.procedure.ProcedureCallMemento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.magazineluiza.wishlist.domain.entity.Produto;
import br.com.magazineluiza.wishlist.domain.repository.ProdutoRepository;

@Service
public class ProdutoService implements IProduto {
    @Autowired
    private ProdutoRepository _produtoRepository;

    @Override
    public Iterable<Produto> GetAll() {
        return _produtoRepository.findAll();
    }

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

    @Override
    public Boolean Delete(Long id) {
        Produto produto = GetById(id);
        if (produto != null) {
            _produtoRepository.delete(produto);
            return true;
        }
        return false;
    }

    @Override
    public Produto Update(Long id, Produto _produto) {
        Produto produto = GetById(id);
        if (produto != null) {
            produto.setNome(_produto.getNome());
            produto.setCategoria(_produto.getCategoria());
            produto.setPreco(_produto.getPreco());
            produto.setDescricao(_produto.getDescricao());
            return Create(produto);
        }
        return null;
    }
}