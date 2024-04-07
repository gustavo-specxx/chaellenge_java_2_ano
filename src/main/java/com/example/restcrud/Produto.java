package com.example.restcrud;

import org.hibernate.annotations.Table;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(appliesTo = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

    @Column
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    private Produto() {
    }

    @Contract(value = " -> new", pure = true)
    public static @NotNull Produto createProduto() {
        return new Produto();
    }

    // getters e setters
}
