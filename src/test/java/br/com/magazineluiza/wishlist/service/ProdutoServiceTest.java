package br.com.magazineluiza.wishlist.service;

import br.com.magazineluiza.wishlist.BaseTest;
import br.com.magazineluiza.wishlist.domain.entity.Produto;
import br.com.magazineluiza.wishlist.domain.entity.ProdutoBuilder;
import br.com.magazineluiza.wishlist.domain.repository.ProdutoRepository;
import br.com.magazineluiza.wishlist.domain.service.ProdutoService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("service")
public class ProdutoServiceTest extends BaseTest {
    @MockBean
    private ProdutoRepository _produtoRepository;

    @InjectMocks
    private ProdutoBuilder _produtoBuilder;

    @InjectMocks
    private ProdutoService _produtoService;

    @Test
    @DisplayName("Test Create Produto Return Success")
    public void CreateProdutoReturnSuccess() {
        Produto produto = _produtoBuilder.defaultValues();
        when(_produtoRepository.save(any(Produto.class))).thenReturn(produto);
        Produto created = _produtoService.Create(produto);
        assertEquals(created.getNome(), produto.getNome());
        assertEquals(created.getDescricao(), produto.getDescricao());
        assertEquals(created.getCategoria(), produto.getCategoria());
    }

    @Test
    @DisplayName("Test GetById Return Success")
    public void getById() {
        Produto produto = _produtoBuilder.defaultValues();
        when(_produtoRepository.findById(any(Long.class))).thenReturn(Optional.of(produto));
        Produto _produto = _produtoService.GetById(produto.getId());
        assertEquals(_produto.getId(), produto.getId());
        assertEquals(_produto.getNome(), produto.getNome());
        assertEquals(_produto.getDescricao(), produto.getDescricao());
        assertEquals(_produto.getCategoria(), produto.getCategoria());
    }

    @Test
    @DisplayName("Test GetById Return null")
    public void getByIdReturnNull() {
        Optional<Produto> produto  = Optional.empty();
        when(_produtoRepository.findById(2L)).thenReturn(produto);
        Produto _produto = _produtoService.GetById(2L);
        assertEquals(_produto, null);
    }

    @Test
    @DisplayName("Test Update Return Success")
    public void UpdateReturnSuccess() {
        Produto produto = _produtoBuilder.defaultValues();
        when(_produtoRepository.findById(any(Long.class))).thenReturn(Optional.of(produto));
        when(_produtoRepository.save(any(Produto.class))).thenReturn(produto);
        Produto _produto = _produtoService.Update(produto.getId(), produto);
        assertEquals(_produto.getId(), produto.getId());
        assertEquals(_produto.getNome(), produto.getNome());
        assertEquals(_produto.getDescricao(), produto.getDescricao());
        assertEquals(_produto.getCategoria(), produto.getCategoria());
    }

    @Test
    @DisplayName("Test Update Return null")
    public void UpdateReturnNull() {
        Optional<Produto> produto  = Optional.empty();
        when(_produtoRepository.findById(2L)).thenReturn(produto);
        Produto _produto = _produtoService.Update(2L, _produtoBuilder.defaultValues());
        assertEquals(_produto, null);
    }

    @Test
    @DisplayName("Test Delete Return Success")
    public void DeleteReturnSuccess() {
        Produto produto = _produtoBuilder.defaultValues();
        when(_produtoRepository.findById(any(Long.class))).thenReturn(Optional.of(produto));
        Boolean response = _produtoService.Delete(produto.getId());
        assertEquals(response, true);
    }

    @Test
    @DisplayName("Test Delete Return False")
    public void DeleteReturnFalse() {
        Produto produto = _produtoBuilder.defaultValues();
        when(_produtoRepository.findById(any(Long.class))).thenReturn(Optional.of(produto));
        Boolean response = _produtoService.Delete(produto.getId());
        assertEquals(response, false);
    }
}
