package br.com.magazineluiza.wishlist.controllers;

import br.com.magazineluiza.wishlist.BaseTest;
import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.Produto;
import br.com.magazineluiza.wishlist.domain.entity.ProdutoBuilder;
import br.com.magazineluiza.wishlist.domain.service.ProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("controller")
public class ProdutoControllerTest extends BaseTest {
    @InjectMocks
    private ProdutoController produtoController;

    @InjectMocks
    private ProdutoBuilder produtoBuilder;

    @MockBean
    private ProdutoService _produtoService;

    @Test
    @DisplayName("Test Create Produto Return Success")
    public void CreateClienteReturnSuccess() throws Exception {
        String uri = "/produto";
        Produto produto = produtoBuilder.defaultValues();

        when(_produtoService.Create(isA(Produto.class)))
                .thenReturn(produto);

        String inputJson = super.mapToJson(produto);
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson))
                .andReturn()
                .getResponse();

        assertEquals(response.getStatus(), HttpStatus.CREATED.value());
        Produto produtoResponse = mapFromJson(response.getContentAsString(), Produto.class);
        assertEquals(produtoResponse.getId(), produto.getId());
        assertEquals(produtoResponse.getNome(), produto.getNome());
        assertEquals(produtoResponse.getDescricao(), produto.getDescricao());
        assertEquals(produtoResponse.getPreco(), produto.getPreco());
    }
    @Test
    @DisplayName("Test Buscar Produto por Id Return Success")
    public void GetByIdSuccess() throws Exception {
        String uri = "/produto/";
        Produto produto = produtoBuilder.defaultValues();

        when(_produtoService.GetById(isA(Long.class)))
                .thenReturn(produto);

        MockHttpServletResponse response = (MockHttpServletResponse) mvc.perform(MockMvcRequestBuilders.get(uri,produto.getId()))
                .andExpect(status().isOk())
                .andReturn();

        Produto produtoResponse = mapFromJson(response.getContentAsString(), Produto.class);
        assertEquals(produtoResponse.getId(), produto.getId());
        assertEquals(produtoResponse.getCategoria(), produto.getCategoria());
        assertEquals(produtoResponse.getDescricao(), produto.getDescricao());
        assertEquals(produtoResponse.getPreco(), produto.getPreco());

    }

    @Test
    @DisplayName("Test Update Produto Return Success")
    public void UpdateReturnSuccess() throws Exception {
        String uri = "/produto/";
        Produto produto = produtoBuilder.defaultValues();

        when(_produtoService.Create(isA(Produto.class)))
                .thenReturn(produto);

        String inputJson = super.mapToJson(produto);
        MockHttpServletResponse response = mvc.perform(MockMvcRequestBuilders.put(uri,produto.getId())
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(inputJson))
                .andReturn()
                .getResponse();

        assertEquals(response.getStatus(), HttpStatus.NO_CONTENT.value());
        Produto produtoResponse = mapFromJson(response.getContentAsString(), Produto.class);
        assertEquals(produtoResponse.getId(), produto.getId());
        assertEquals(produtoResponse.getCategoria(), produto.getCategoria());
        assertEquals(produtoResponse.getDescricao(), produto.getDescricao());
        assertEquals(produtoResponse.getPreco(), produto.getPreco());

    }

    @Test
    @DisplayName("Test Delete Return Success")
    public void DeleteReturnSuccess() throws Exception {
        String uri = "/produto/";
        Produto produto = produtoBuilder.defaultValues();

        when(_produtoService.Delete(isA(Long.class)))
                .thenReturn(true);

        MockHttpServletResponse response = (MockHttpServletResponse) mvc.perform(MockMvcRequestBuilders.delete(uri,produto.getId()))
                .andExpect(status().isOk())
                .andReturn();
    }
}
