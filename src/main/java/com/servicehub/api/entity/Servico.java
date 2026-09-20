package com.servicehub.api.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "tb_servico")
@Schema(description = "Entidade que representa um serviço no ServiceHub")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID do serviço", example = "1")
    private Long id;

    @Column(nullable = false, length = 100)
    @Schema(description = "Nome do serviço", example = "Manutenção de Computadores")
    private String nome;

    @Column(length = 255)
    @Schema(description = "Descrição detalhada", example = "Formatação e limpeza preventiva.")
    private String descricao;

    @Column(nullable = false)
    @Schema(description = "Preço cobrado", example = "150.00")
    private BigDecimal preco;

    public Servico() {}

    public Servico(Long id, String nome, String descricao, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }
}