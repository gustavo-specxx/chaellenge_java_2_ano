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


@Entity
@Table(name = "TB_PRODUTO")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID_PRODUTO", insertable=false, updatable=false)
    private Long id;

    @Column(name="NOME_PRODUTO")
    private String nome;

    @Column(name="DESCRICAO_PRODUTO")
    private String descricao;



    @ManyToOne
    @JoinColumn(name = "ID_CLIENTE")
    private Usuario usuario;

    private Produto() {
    }

    @Contract(value = " -> new", pure = true)
    public static @NotNull Produto createProduto() {
        return new Produto();
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
