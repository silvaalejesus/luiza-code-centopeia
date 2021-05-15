package br.com.magazineluiza.wishlist.domain.service;

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
        // Optional<Cliente> cliente = _clienteRepository.findById(id);
        // if (Cliente.isPresent()) {
        //     return Cliente.get();
        // }
        return null;
    }

    @Override
    public Produto Create(Produto produto) {
        return _produtoRepository.save(produto);
    }

    // salvar
    @param
    @return

    public Produto Create(Produto produto) {
        return _produtoRepository.save(produto);
    }

    // atualizar
    @param
    @return

    public (produto produto) {
        return _produtoRepository
        .findById(produto.getId())
        .map(
            produtoExiste -> {
                if (produto.getNome() != null) {
                    produtoExiste.setNome(produto.getNome());
                }
                if (produto.getDescricao() != null) {
                    produtoExiste.setDescricao(produto.getNome());
                }
                if (produto.getPreco() != null) {
                    produtoExiste.setPreco(produto.getPreco());
                }
                if (produto.getCategoria() != null) {
                    produtoExiste.setCategoria(produto.getCategoria());
                }

                return produtoExiste;
            }
        )
        .map(_produtoRepository::save);
    }
}

package br.com.magalu.referenciaprojetofinal.service;

import br.com.magalu.referenciaprojetofinal.domain.entity.Carro;
import br.com.magalu.referenciaprojetofinal.domain.repository.CarroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CarroService {

    @Autowired
    private CarroRepository carroRepository;

    public Carro salvarProduto(Carro carro){
        // objeto.getnullo.equals(valor)
        //Const.equals(objeto.getnullo)
        //objeto.getnullo == null
        return carroRepository.save(carro);
    }

    public List<Carro> list(){
        return (List<Carro>) carroRepository.findAll();
    }

    public Carro updateCarro(Carro carro){
        Carro retorno = carroRepository.getOne(carro.getId());
        if(retorno != null){
            retorno.setNome(carro.getNome());
            retorno.setCor(carro.getCor());
            retorno.setAno(carro.getAno());
            carroRepository.save(retorno);
        }
        return carroRepository.save(carro);
    }

    public void deletarCarro(Long id){
        Carro retorno = carroRepository.getOne(id);
        if(retorno != null){
            carroRepository.deleteById(id);
        }
    }

}
