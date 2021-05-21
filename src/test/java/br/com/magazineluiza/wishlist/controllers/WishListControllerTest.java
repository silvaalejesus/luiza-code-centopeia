package br.com.magazineluiza.wishlist.controllers;

import br.com.magazineluiza.wishlist.BaseTest;
import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;
import br.com.magazineluiza.wishlist.domain.entity.Produto;
import br.com.magazineluiza.wishlist.domain.entity.ProdutoBuilder;
import br.com.magazineluiza.wishlist.service.WishlistService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class WishListControllerTest extends BaseTest {
    @InjectMocks
    private WishListController wishlistController;

    @InjectMocks
    private ProdutoBuilder produtoBuilder;

    @InjectMocks
    private ClienteBuilder clienteBuilder;

    @MockBean
    private WishlistService _wishlistService;

    @Test
    @DisplayName("Test Create Wishlist Return Success")
    public void CreateClienteReturnSuccess() throws Exception {
        String uri = "/wishList/";
        Cliente cliente = clienteBuilder.defaultValues();
        Produto produto = produtoBuilder.defaultValues();
        Set<Long> idProduto = new HashSet<>();
        idProduto.add(1L);

        MockHttpServletResponse response =  (MockHttpServletResponse) mvc.perform(MockMvcRequestBuilders.post(uri,cliente.getId(),idProduto))
                .andExpect(status().isCreated())
                .andReturn();
    }

    @Test
    @DisplayName("Test Create GetProdutosByIdCliente Return Success")
    public void GetProdutosByIdClienteReturnSuccess() throws Exception {
        String uri = "/wishList/cliente/";
        Cliente cliente = clienteBuilder.defaultValues();
        Produto produto = produtoBuilder.defaultValues();
        Set<Produto> listaProdutos = new HashSet<>();
        listaProdutos.add(produto);
        when(_wishlistService.GetProdutosByIdCliente(isA(Long.class)))
                .thenReturn(listaProdutos);

        MockHttpServletResponse response =  (MockHttpServletResponse) mvc.perform(MockMvcRequestBuilders.get(uri,cliente.getId()))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("Test Create GetProdutosByIdCliente Return Success")
    public void GetProdutosByDeleteReturnSuccess() throws Exception {
        String uri = "wishList/cliente/1/produto/1";
        Cliente cliente = clienteBuilder.defaultValues();
        Produto produto = produtoBuilder.defaultValues();
        when(_wishlistService.Delete(isA(Long.class),isA(Long.class)))
                .thenReturn(true);

        MockHttpServletResponse response =  (MockHttpServletResponse) mvc.perform(MockMvcRequestBuilders.delete(uri))
                .andExpect(status().isOk())
                .andReturn();
    }

    @Test
    @DisplayName("Test Insert Return Success")
    public void InsertReturnSuccess() throws Exception {
        String uri = "wishList/cliente/1/produto/1";
        Cliente cliente = clienteBuilder.defaultValues();
        Produto produto = produtoBuilder.defaultValues();
        when(_wishlistService.Insert(isA(Long.class),isA(Long.class)))
                .thenReturn(true);

        MockHttpServletResponse response =  (MockHttpServletResponse) mvc.perform(MockMvcRequestBuilders.post(uri))
                .andExpect(status().isCreated())
                .andReturn();
    }
}
