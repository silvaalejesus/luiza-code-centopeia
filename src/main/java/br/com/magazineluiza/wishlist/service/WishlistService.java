package br.com.magazineluiza.wishlist.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.Produto;

@Service
public class WishlistService implements IWishlistService {
  private static final String _WishlistRepository = null;

  @Autowired
  private ClienteService _clienteService;

  @Autowired
  private ProdutoService _produtoService;

  @Override
  public Object Create(Long idCliente, Set<Long> idProdutos) throws Exception {
    if (idProdutos.size() > 20) {
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

  @Override
  public Set<Produto> GetProdutosByIdCliente(Long idCliente) {
    Cliente cliente = _clienteService.GetById(idCliente);
    if (cliente != null) {
      return cliente.getProdutos();
    }
    return null;
  }

  @Override
  public Produto GetProdutoByIdProduto(Long idCliente, Long idProdutos) {
    Cliente cliente = _clienteService.GetById(idCliente);
    if (cliente != null) {
      Set<Produto> produtos = cliente.getProdutos();
      return produtos.stream().filter(item -> item.getId().equals(idProdutos)).findFirst().orElse(null);
    }
    return null;
  }

  @Override
  public Boolean Delete(Long idCliente, Long idProduto) {
    Cliente cliente = _clienteService.GetById(idCliente);
    if (cliente != null) {
      cliente.getProdutos().removeIf(produto -> produto.getId().equals(idProduto));
      _clienteService.Create(cliente);
      return true;
    }
    return false;
  }

  @Override
  public Boolean Insert(Long idCliente, Long idProduto) {
    Cliente cliente = _clienteService.GetById(idCliente);
    if (cliente != null) {
      Produto produto = _produtoService.GetById(idProduto);
      cliente.getProdutos().add(produto);
      _clienteService.Create(cliente);
      return true;
    }
    return false;
  }
}
