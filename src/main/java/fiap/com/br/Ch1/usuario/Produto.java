package fiap.com.br.Ch1.usuario;

import jakarta.persistence.*;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Usando a estratégia IDENTIY para geração automática de ID
    @Column(name = "ID_PRODUTO") // Nome da coluna da tabela
    private Long id;

    @Column(name = "NOME_PRODUTO")
    private String nome;

    @Column(name = "PRECO_PRODUTO")
    private Integer preco;

    @Column(name = "TIPO_PRODUTO")
    private String tipo;

    @Column(name = "DESCRICAO_PRODUTO")
    private String descricao;

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

    public Integer getPreco() {
        return preco;
    }

    public void setPreco(Integer preco) {
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
