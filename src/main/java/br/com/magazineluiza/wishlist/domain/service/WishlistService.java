package br.com.magazineluiza.wishlist.domain.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.Produto;

@Service
public class WishlistService implements IWishlistService {
  @Autowired
  private ClienteService _clienteService;

  @Autowired
  private ProdutoService _produtoService;

  @Override
  public Object Create(Long idCliente, Set<Long> idProdutos) throws Exception {
    if(idProdutos.size() > 20) {
      throw new Exception("não pode adicionar mais de 20 produtos!");
    }

    Cliente cliente = _clienteService.GetById(idCliente);
    if (cliente != null) {
      Set<Produto> produtos = new HashSet<>();

      for (Long idProduto : idProdutos) {
        Produto produto = _produtoService.GetById(idProduto);
        produtos.add(produto);
      }
      cliente.setProdutos(produtos);
      return _clienteService.Create(cliente);
    }
    return null;
  }

}
