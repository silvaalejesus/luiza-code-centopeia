package br.com.magazineluiza.wishlist.controllers;

import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.magazineluiza.wishlist.domain.entity.Produto;
import br.com.magazineluiza.wishlist.service.ProdutoService;
import io.swagger.annotations.ApiOperation;

/**
 * ProdutoController
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService _produtoService;

    @ApiOperation (value = "Buscar todos os produtos")
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<Iterable<Produto>> GetAll() {
        return new ResponseEntity<Iterable<Produto>>(_produtoService.GetAll(), HttpStatus.OK);
    }

    @ApiOperation (value = "Buscar produto por ID")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> GetById(@PathVariable(value = "id") long id) {
        Produto produto = _produtoService.GetById(id);
        if (produto != null)
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation (value = "Criar produto")
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Produto> Create(@RequestBody Produto produto) {
        return new ResponseEntity<Produto>(_produtoService.Create(produto), HttpStatus.CREATED);
    }

    @ApiOperation (value = "Remover um produto")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "id") long id) {
        try {
            Boolean deletedProduct = _produtoService.Delete(id);
            if (deletedProduct)
                return new ResponseEntity<Object>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar produto, existe cliente vinculado a ele" + e,
                    HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation (value = "Atualizar informações do produto")
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Produto> Update(@PathVariable(value = "id") long id, @RequestBody Produto produto) {
        Produto product = _produtoService.Update(id, produto);
        if (product != null)
            return new ResponseEntity<Produto>(product, HttpStatus.NO_CONTENT);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}