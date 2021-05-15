package br.com.magazineluiza.wishlist.domain.service;

import br.com.magazineluiza.wishlist.domain.entity.Produto;
import br.com.magazineluiza.wishlist.domain.repository.ClienteRepository;
import br.com.magazineluiza.wishlist.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WishListService{

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    //adicionar produto

//    public Produto adicionarProduto(Produto produto){
//
//    }

}