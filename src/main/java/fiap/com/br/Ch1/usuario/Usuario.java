
package fiap.com.br.Ch1.usuario;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity
@Table(name = "TB_CADASTRO")
public class Usuario {

    @Id
    @Column(name="ID_CLIENTE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="EMAIL_CLIENTE")
    private String nome;

    @Column(name="SENHA_CLIENTE")
    private String senha;

    @OneToMany(mappedBy = "usuario", cascade=CascadeType.ALL)
    private List<Produto> produtos;

    public List<Produto> getProdutos() {
        return produtos;
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



    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
