//package br.com.magazineluiza.wishlist.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.magazineluiza.wishlist.domain.entity.Produto;
//import br.com.magazineluiza.wishlist.domain.entity.WishList;
//import br.com.magazineluiza.wishlist.domain.service.ProdutoService;
//import org.springframework.web.bind.annotation.RequestParam;
//
//import java.util.List;
//
//
//@RestController
//@RequestMapping("/adicionar-produto")
//public class WishListController<WishListService> {
//
//    @Autowired
//    private ProdutoService _produtoService;
//
//    @Autowired
//    private WishListService _wishListService;
//
//    @RequestMapping(value= "/cadastro-produto", method = RequestMethod.POST)
//    public Produto Create(@RequestBody Produto produto) {
//        return _produtoService.Create(produto);
//    }


//    @RequestMapping(value = "/wishlist", method = RequestMethod.POST)
//    public WishList Create(@RequestBody WishList WishList) {
//        return _WishListService.Create(WishList);
//
//    }

//    @RequestMapping(value="/mostrar-produto", method=RequestMethod.GET)
//    public List<Produto> listar() {
//        return WishListService.list();
//    }
//}
