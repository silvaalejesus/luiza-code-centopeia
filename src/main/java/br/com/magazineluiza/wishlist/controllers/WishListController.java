package br.com.magazineluiza.wishlist.controllers;


@RestController
@RequestMapping("/adicionar-produto")
public class WishListController {
    @Autowired
    private ProdutoService _produtoService;

    @RequestMapping(method = RequestMethod.POST)
    public Produto Create(@RequestBody Produto produto) {
        return _produtoService.Create(produto);
        
    }
}
    
}
