package br.com.magazineluiza.wishlist.domain.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String categoria;
    private Double preco;
    private String descricao;

    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "produtos")
    private Set<Cliente> clientes = new HashSet<>();

    public Produto() {

    }

    public Produto(Long id, String nome, String categoria, Double preco, String descricao) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
        this.descricao = descricao;
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

    @JsonIgnore
    public Set<Cliente> getClientes() {
        return clientes;
    }

     @JsonProperty
     public void setClientes(Set<Cliente> clientes) {
         this.clientes = clientes;
     }
}