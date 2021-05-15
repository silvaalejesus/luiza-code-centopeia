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
import br.com.magazineluiza.wishlist.domain.service.ProdutoService;

/**
 * ProdutoController
 */
@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    private ProdutoService _produtoService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Produto> GetById(@PathVariable(value = "id") long id) {
        Produto produto = _produtoService.GetById(id);
        if (produto != null)
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Produto> Create(@RequestBody Produto produto) {
        return new ResponseEntity<Produto>(_produtoService.Create(produto), HttpStatus.CREATED);
    }
}