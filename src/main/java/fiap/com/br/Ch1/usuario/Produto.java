package fiap.com.br.Ch1.usuario;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_PRODUTO")
    private Long id;

    @Column(name = "NOME_PRODUTO", nullable = false, length = 100)
    private String nome;

    @Column(name = "PRECO_PRODUTO", nullable = false)
    private BigDecimal preco;

    @Column(name = "TIPO_PRODUTO", length = 100)
    private String tipo;

    @Column(name = "DESCRICAO_PRODUTO", length = 255)
    private String descricao;

    // Construtor padrão
    public Produto(String produtoA, int i) {}

    // Construtor completo
    public Produto(String nome, BigDecimal preco, String tipo, String descricao) {
        this.nome = nome;
        this.preco = preco;
        this.tipo = tipo;
        this.descricao = descricao;
    }

    public Produto() {
        
    }

    public Produto(String s) {
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public BigDecimal getPreco() { return preco; }
    public void setPreco(BigDecimal preco) { this.preco = preco; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", preco=" + preco +
                ", tipo='" + tipo + '\'' +
                ", descricao='" + descricao + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return Objects.equals(id, produto.id) &&
                Objects.equals(nome, produto.nome) &&
                Objects.equals(preco, produto.preco) &&
                Objects.equals(tipo, produto.tipo) &&
                Objects.equals(descricao, produto.descricao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, preco, tipo, descricao);
    }
}
