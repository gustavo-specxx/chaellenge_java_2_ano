package fiap.com.br.Ch1.usuario;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="TB_AVALIACOES")
@SequenceGenerator(name = "AVALIACAO_SEQ", sequenceName = "TB_AVALIACOES_SEQ", allocationSize = 1)
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AVALIACAO_SEQ")
    @Column(name="ID_AVALIACOES")
    private Long idAvaliacoes;

    @Column(name="ID_CLIENTE", insertable=false, updatable=false)
    private Long idCliente;

    @Column(name="ID_PRODUTO", insertable=false, updatable=false)
    private Long idProduto;

    @Column(name="ID_IA")
    @NotNull
    private int idIa;

    @Column(name="COMENTARIO", length=500)
    @NotNull
    @Size(max = 500)
    private String comentario;

    @Column(name="DATA_AVALIACAO")
    @NotNull
    private Calendar dataAvaliacao;

    @ManyToOne
    @JoinColumn(name="ID_CLIENTE")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="ID_PRODUTO")
    private Produto produto;

    // Getters e Setters
    public Long getIdAvaliacoes() {
        return idAvaliacoes;
    }

    public void setIdAvaliacoes(Long idAvaliacoes) {
        this.idAvaliacoes = idAvaliacoes;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdIa() {
        return idIa;
    }

    public void setIdIa(int idIa) {
        this.idIa = idIa;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Calendar getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(Calendar dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }
}
