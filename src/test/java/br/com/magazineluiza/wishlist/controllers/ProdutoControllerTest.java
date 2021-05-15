package br.com.magazineluiza.wishlist.controllers;

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
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest
@ActiveProfiles("controller")
public class ProdutoControllerTest {
    @InjectMocks
    protected ProdutoController ProdutoController;

    @Mock
    private ProdutoService service;

    @Test
    @DisplayName("Test createShouldReturnProduro Success")
    public void createShouldReturnProduto() {
        Produto produto = new ProdutoBuilder().defaultValues();

        when(service.Create(produto)).thenReturn(produto);
        Produto result = ProdutoController.Create(produto);

        assertEquals(produto.getNome(), result.getNome());
        assertEquals(produto.getCategoria(), result.getCategoria());
        assertEquals(produto.getDescricao(), result.getDescricao());
        assertEquals(produto.getPreco(), result.getPreco());
    }
}
