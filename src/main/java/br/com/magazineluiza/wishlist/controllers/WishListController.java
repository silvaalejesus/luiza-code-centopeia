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

import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.service.WishlistService;

/**
 * WishListController
 */
@RestController
@RequestMapping("/wishList")
public class WishListController {
    @Autowired
    private WishlistService _wishlistService;

    @RequestMapping(value = "/{idCliente}", method = RequestMethod.POST)
    public ResponseEntity<Object> Create(@PathVariable(value = "idCliente") long idCliente,
            @RequestBody Set<Long> idProdutos) {
        try {
            return new ResponseEntity<Object>(_wishlistService.Create(idCliente, idProdutos), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao adicionar produtos na wishList" + e, HttpStatus.BAD_REQUEST);
        }
    }
}
