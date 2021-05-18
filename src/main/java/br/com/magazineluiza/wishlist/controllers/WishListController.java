package br.com.magazineluiza.wishlist.controllers;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.magazineluiza.wishlist.domain.entity.Produto;
import br.com.magazineluiza.wishlist.domain.service.WishlistService;
import io.swagger.annotations.ApiOperation;

/**
 * WishListController
 */
@RestController
@RequestMapping("/wishList")
public class WishListController {
    @Autowired
    private WishlistService _wishlistService;

    @ApiOperation(value = "Adicionar vários produtos na WishList")
    @RequestMapping(value = "/{idCliente}", method = RequestMethod.POST)
    public ResponseEntity<Object> Create(@PathVariable(value = "idCliente") long idCliente,
            @RequestBody Set<Long> idProdutos) {
        try {
            return new ResponseEntity<Object>(_wishlistService.Create(idCliente, idProdutos), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao adicionar produtos na wishList" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Consultar todos os produtos da Wishlist do cliente")
    @RequestMapping(value = "/cliente/{idCliente}", method = RequestMethod.GET)
    public ResponseEntity<Set<Produto>> GetProdutosByIdCliente(@PathVariable(value = "idCliente") long idCliente) {
        Set<Produto> produtos = _wishlistService.GetProdutosByIdCliente(idCliente);
        if (produtos != null)
            return new ResponseEntity<Set<Produto>>(produtos, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Consultar se um determinado produto está na Wishlist do cliente")
    @RequestMapping(value = "/cliente/{idCliente}/produto/{idProduto}", method = RequestMethod.GET)
    public ResponseEntity<Produto> GetById(@PathVariable(value = "idCliente") long idCliente,
            @PathVariable(value = "idProduto") long idProduto) {
        Produto produto = _wishlistService.GetProdutoByIdProduto(idCliente, idProduto);
        if (produto != null)
            return new ResponseEntity<Produto>(produto, HttpStatus.OK);
        else
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(value = "Remover produto da WishList do cliente;")
    @RequestMapping(value = "/cliente/{idCliente}/produto/{idProduto}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> Delete(@PathVariable(value = "idCliente") long idCliente,
            @PathVariable(value = "idProduto") long idProduto) {
        try {
            Boolean deletedWishlist = _wishlistService.Delete(idCliente, idProduto);
            if (deletedWishlist)
                return new ResponseEntity<Object>(HttpStatus.OK);
            else
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar item da WishList" + e, HttpStatus.BAD_REQUEST);
        }
    }

    @ApiOperation(value = "Adicionar Produto único na WishList")
    @RequestMapping(value = "/cliente/{idCliente}/produto/{idProduto}", method = RequestMethod.POST)
    public ResponseEntity<Object> Insert(@PathVariable(value = "idCliente") long idCliente,
            @PathVariable(value = "idProduto") Long idProduto) {
        try {
            Boolean deletedWishlist = _wishlistService.Insert(idCliente, idProduto);
            return new ResponseEntity<Object>(deletedWishlist, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao adicionar produtos na wishList" + e, HttpStatus.BAD_REQUEST);
        }
    }
}