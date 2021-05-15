package br.com.magazineluiza.wishlist.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "produtos")
public class Produto {

    public Produto(){}

    public Produto(String nome, String categoria, Double preco, String descricao) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="nome")
    private String nome;
    @Column(name="categoria")
    private String categoria;
    @Column(name="preco")
    private Double preco;
    @Column(name="descricao")
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY,mappedBy = "produtos")
    private List<Cliente> clientes;
    @JsonIgnore
    public List<Cliente> getClientes() {
        return clientes;
    }
    @JsonProperty
    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
    return "Produto{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", categoria='" + categoria + '\'' +
            ", preco='" + preco + '\'' +
            ", descricao='" + descricao + '\'' +
            '}';
}
}