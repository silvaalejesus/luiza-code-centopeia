package br.com.magazineluiza.wishlist.service;

import br.com.magazineluiza.wishlist.BaseTest;
import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.Produto;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;
import br.com.magazineluiza.wishlist.domain.entity.ProdutoBuilder;
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

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("service")
public class WishListServiceTest extends BaseTest {

    @InjectMocks
    private ProdutoService _produtoService;

    @InjectMocks
    private ClienteBuilder _clienteBuilder;

    @InjectMocks
    private ProdutoBuilder _produtoBuilder;

    @InjectMocks
    private ClienteService _clienteService;

    @MockBean
    private WishlistService _wishlistService;

    @Test
    @DisplayName("Test Create Wishlist Return Success")
    public void CreateClienteReturnSuccess() throws Exception {
        Cliente cliente = _clienteBuilder.defaultValues();
        Produto produto = _produtoBuilder.defaultValues();
        Set<Long> idProduto = new HashSet<>();
        idProduto.add(1L);
        when(_clienteService.GetById(any(Long.class))).thenReturn(cliente);
        when(_produtoService.GetById(any(Long.class))).thenReturn(produto);
        when(_clienteService.Create(any(Cliente.class))).thenReturn(cliente);
        Object wishlist = _wishlistService.Create(cliente.getId(),idProduto);
    }

    @Test
    @DisplayName("Test Return  GetProdutosByIdCliente Success")
    public void GetProdutosByIdReturnSuccess() {
        Cliente cliente = _clienteBuilder.defaultValues();
        when(_clienteService.GetById(any(Long.class))).thenReturn(cliente);
        Set<Produto> listaProduto = _wishlistService.GetProdutosByIdCliente(cliente.getId());
    }

    @Test
    @DisplayName("Test Return Delete Success")
    public void DeleteReturnSuccess() {
        Cliente cliente = _clienteBuilder.defaultValues();
        Produto produto = _produtoBuilder.defaultValues();
        when(_clienteService.GetById(any(Long.class))).thenReturn(cliente);
        Boolean response = _wishlistService.Delete(cliente.getId(),produto.getId());
        assertEquals(response, true);

    }

    @Test
    @DisplayName("Test Return Insert Success")
    public void InsertReturnSuccess() {
        Cliente cliente = _clienteBuilder.defaultValues();
        Produto produto = _produtoBuilder.defaultValues();
        when(_clienteService.GetById(any(Long.class))).thenReturn(cliente);
        when(_produtoService.GetById(any(Long.class))).thenReturn(produto);
        when(_clienteService.Create(any(Cliente.class))).thenReturn(cliente);
        Boolean response = _wishlistService.Delete(cliente.getId(),produto.getId());
        assertEquals(response, true);
    }
}
