package br.com.magazineluiza.wishlist.domain.entity;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProdutoTest {
    @Test
    public void criandoInstanciaProduto(){
        Produto produto = new ProdutoBuilder().defaultValues();
        assertThat(produto).isNotNull();
    }
}
