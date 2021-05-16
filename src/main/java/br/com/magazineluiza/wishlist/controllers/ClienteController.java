package br.com.magazineluiza.wishlist.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Autowired;


import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.service.ClienteService;

///**
// * ClienteController
// */
//@RestController
//@RequestMapping("/cliente")
//public class ClienteController {
//    @Autowired
//    private ClienteService _clienteService;
//
//    @RequestMapping(method = RequestMethod.POST)
//    public Cliente Create(@RequestBody Cliente cliente) {
//        return _clienteService.Create(cliente);
//    }
//}

@CrossOrigin
@RestController(value = "cliente")
@Api("CRUD - CLIENTES")
public class ClienteController{

    @Autowired
    private ClienteService clienteService;

    //salvar
    @ApiOperation(value = "Salvar cliente")
    @RequestMapping(value = "/cliente", method = RequestMethod.POST)
    public ResponseEntity<Cliente> salvarCliente(@RequestBody Cliente cliente){
        return new ResponseEntity<Cliente>(clienteService.salvarCliente(cliente), HttpStatus.CREATED);
    }

    //Listar
    @ApiOperation(value = "listar todos os clientes")
    @RequestMapping(value = "/cliente", method = RequestMethod.GET)
    public ResponseEntity<List<Cliente>> listar(){
        return new ResponseEntity<>(clienteService.list(), HttpStatus.ACCEPTED);
    }

    //deletar
    @ApiOperation(value = "Deletar cliente atraves do id")
    @RequestMapping(value = "/cliente", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletarCliente(@RequestParam("id") Long id){
        try {
            clienteService.deletarCliente(id);
            return new ResponseEntity<>("Deletado com sucesso", HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>("Erro ao deletar carro"+ e, HttpStatus.BAD_REQUEST);
        }
    }

    //listar produtos
    @ApiOperation(value = "Trazer produto atraves do id")
    @RequestMapping(value = "/cliente/produto", method = RequestMethod.GET)
    public List<ProdutoNomeNoBanco> buscaPorProdutoEmCliente(@RequestParam("id") Long id)
    {
        return  clienteService.buscaPorProdutoEmCliente(id);
    }

    //inserir produtos
    @ApiOperation(value = "Salvar novo produto para o cliente")
    @RequestMapping(value = "/cliente/produto", method = RequestMethod.POST)
    public ResponseEntity<Object>salvaNovoItemWishLis(@RequestBody Long id_cliente,
                                                      @RequestBody Long id_produto) {
        try {
            Cliente cliente = (Cliente) clienteService.inserirNaListaDeClienteoProduto(id_cliente,id_produto);
            return new ResponseEntity<>(cliente, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Erro ao deletar cliente", HttpStatus.BAD_REQUEST);
        }
    }


}