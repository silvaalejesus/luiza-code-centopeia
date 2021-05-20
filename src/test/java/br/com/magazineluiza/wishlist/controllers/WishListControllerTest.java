package br.com.magazineluiza.wishlist.controllers;

import br.com.magazineluiza.wishlist.BaseTest;
import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;
import br.com.magazineluiza.wishlist.domain.entity.ProdutoBuilder;
import br.com.magazineluiza.wishlist.domain.service.WishlistService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;

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
        String uri = "/wishList";
        Cliente cliente = clienteBuilder.defaultValues();
//
//        when(_wishlistService.Create(isA(Long.class)))
//                .thenReturn(cliente);
//
//        String inputJson = super.mapToJson(cliente);
//        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post(uri)
//                .contentType(MediaType.APPLICATION_JSON_VALUE)
//                .content(inputJson))
//                .andReturn()
//                .getResponse();
//
//        assertEquals(response.getStatus(), HttpStatus.CREATED.value());
//        Cliente clienteResponse = mapFromJson(response.getContentAsString(), Cliente.class);
//        assertEquals(clienteResponse.getId(), cliente.getId());
//        assertEquals(clienteResponse.getNome(), cliente.getNome());
//        assertEquals(clienteResponse.getSobrenome(), cliente.getSobrenome());
//        assertEquals(clienteResponse.getCpf(), cliente.getCpf());
    }
}
