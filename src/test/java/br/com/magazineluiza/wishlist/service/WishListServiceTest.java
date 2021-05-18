package br.com.magazineluiza.wishlist.service;

import br.com.magazineluiza.wishlist.domain.entity.Cliente;
import br.com.magazineluiza.wishlist.domain.entity.Produto;
import br.com.magazineluiza.wishlist.domain.entity.ClienteBuilder;
import br.com.magazineluiza.wishlist.domain.entity.ProdutoBuilder;
import br.com.magazineluiza.wishlist.domain.repository.ClienteRepository;
import br.com.magazineluiza.wishlist.domain.repository.ProdutoRepository;
import br.com.magazineluiza.wishlist.domain.service.ClienteService;
import br.com.magazineluiza.wishlist.domain.service.WishlistService;
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
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@ActiveProfiles("service")
public class WishListServiceTest {
    @InjectMocks
    private ClienteRepository _clienteRepository;

    @InjectMocks
    private ProdutoRepository _produtoRepository;

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
    public void CreateClienteReturnSuccess() {
//        Cliente cliente = _clienteBuilder.defaultValues();
//        Produto produto = _produtoBuilder.defaultValues();
//        when(_clienteRepository.findById(any(Long.class))).thenReturn(Optional.of(cliente));
//        when(_produtoRepository.findById(any(Long.class))).thenReturn(Optional.of(produto));
//        //Nao sei como setar o id do produto aqui com tipo que esta sendo passado.
//        Cliente wishlist = _wishlistService.Create(cliente.getId());
    }
    @Test
    @DisplayName("Test Return Products from cliente Success")
    public void GetProdutosByIdClienteReturnSuccess() {
        Cliente cliente = _clienteBuilder.defaultValues();
        when(_clienteRepository.findById(any(Long.class))).thenReturn(Optional.of(cliente));
        Set<Produto> listaProduto = _wishlistService.GetProdutosByIdCliente(1L);

    }
}
