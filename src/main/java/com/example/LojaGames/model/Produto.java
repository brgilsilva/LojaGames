package com.example.LojaGames.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = ("tb_produtos"))
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @NotBlank(message = "O atributo nome é obrigatório")
    @Size(max = 200, message = "O atributo nome deve ter no maximo 200 caracteres")
    private String nome;

    @Size(max = 500, message = "O atributo descrição deve ter no maximo 500 caracteres")
    private String descricao;

    @NotNull(message = "O atributo quantidade é obrigatório")
    private Integer quantidade;

    @NotNull(message = "O atributo preço é obrigatório")
    private  Double preco;

    @Size(max = 5000, message = "O atributo foto deve ter no maximo 5000 caracteres")
    private String foto;


    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}

