package fiap.com.br.Ch1.reclamacoes;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "reclamacao")
public class Reclamacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String nomeproduto;
    @Column
    private String reclamacao;
    @OneToMany(mappedBy = "reclamacao")
    private List<Reclamacao> reclamacoes;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNomeproduto() {
        return nomeproduto;
    }
    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }
    public String getReclamacoes() {
        return reclamacao;
    }
    public void setReclamacoes(String reclamacao) {
        this.reclamacao = reclamacao;
    }
}
