package fiap.com.br.Ch1.usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PRODUTO")
    private Long id;

    @Column(name="NOME_PRODUTO")
    private String nome;

    @Column(name="DESCRICAO_PRODUTO")
    private String descricao;

    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    @JsonBackReference
    private Cliente cliente;

    // Construtor padrão
    public Produto() {
    }

    // Getters e Setters
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}