package br.com.magazineluiza.wishlist.domain.entity;

import javax.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    public Cliente(){

    }
    public Cliente(String nome, String sobrenome, String cpf) {
    this.nome = nome;
    this.sobrenome = sobrenome;
    this.cpf = cpf;
    }

    private List<Produto> produto;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;
    private String sobrenome;
    @Column(unique = true)
    private String cpf;

    public Cliente(String nome, String sobrenome, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
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

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
    return "Cliente{" +
        "id=" + id +
        ", nome='" + nome + '\'' +
        ", sobrenome='" + sobrenome + '\'' +
        ", cpf='" + cpf + '\'' +
        '}';
}