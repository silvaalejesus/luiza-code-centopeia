package br.com.magazineluiza.wishlist.domain.service;

import br.com.magazineluiza.wishlist.domain.entity.Produto;
import br.com.magazineluiza.wishlist.domain.repository.ClienteRepository;
import br.com.magazineluiza.wishlist.domain.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WishListService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    //adicionar produto na lista do cliente

    public Cliente adicionarProduto(Cliente cliente) {
        List<ProdutoNomeNoBanco> listaDeProdutosExistentes = new ArrayList<>();

        //buscar produto e salvar ou adicionar
        //percorrer o cliente vendo os seus produtos
        for (ProdutoNomeNoBanco p : cliente.getProdutos()) {
            //buscar no banco se o produto existe
            ProdutoNomeNoBanco produto = produtoRepository.getOne(p.getId_produto());

            //caso exista, cria um relacionamento
            if (ProdutoNomeNoBanco != null) {
                //adiciona na lista auxiliar
                listaDeProdutosExistentes.add(ProdutoNomeNoBanco);
            }
        }

        //setta somente os produtos que existem na lista do cliente
        cliente.setProdutos(listaDeProdutosExistentes);
        return clienteRepository.save(cliente);
    }

    //VER COM PROFESSORA: está listando todos os clientes?
//    public List<Cliente> list(){
//        return (List<Cliente>) clienteRepository.findAll();
//    }


//VER COM PROFESSORA: se essa 'função' deve ser inserida em clientes
    public Cliente updateCliente(Cliente cliente){
        Cliente retorno = clienteRepository.getOne(cliente.getId());
        if (retorno != null){
            retorno.setNome(cliente.getNome());
            retorno.setSobrenome(cliente.getSobrenome());
            retorno.setCpf(cliente.getCpf());
            clienteRepository.save(retorno);

        }
        return clienteRepository.save(cliente);
    }

    //deletar cliente
    public void deletarCliente(Long id){
        Cliente retorno = clienteRepository.getOne(id);
        retorno.getProdutos().removeAll(retorno.getProdutos());

        if(retorno != null){
            clienteRepository.deleteById(id);
        }
    }
    //insere o produto na lista do cliente
    public Object inserirNaListaDeClienteOProduto(Long id_cliente, Long id_produto) throws Exception{
        Cliente cliente = clienteRepository.getOne(id_cliente);
        ProdutoNomeNoBanco produtoNomeNoBanco = produtoRepository.getOne(id_produto);
        if(cliente != null && produto != null){
            cliente.getProdutos().add(ProdutoNomeNoBanco);
            return clienteRepository.save(cliente);
        }
        throw new Exception("teste");
    }

    public Lista<ProdutoNomeNoBanco> buscarProdutoEmCliente(Long id){
        Cliente retorno = clienteRepository.getOne(id);
        return retorno.getProdutos();
    }

}