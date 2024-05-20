package fiap.com.br.Ch1.usuario;

import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "TB_CLIENTE")
@SequenceGenerator(name = "CLI_SEQ", sequenceName = "TB_CLIENTE_SEQ", allocationSize = 1)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLI_SEQ")
    @Column(name = "ID_CLIENTE")
    private Long id;

    @NotNull
    @Column(name = "NOME_CLIENTE")
    private String nome;

    @Email
    @Column(name = "CPF_CLIENTE")
    private String cpfCliente;

    @NotNull
    @Column(name = "DATA_NASCIMENTO_CLIENTE")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Calendar dataNascimentoCliente;

    @NotNull
    @Column(name = "GENERO_CLIENTE")
    private String generoCliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Produto> produtos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Avaliacao> avaliacoes;

    // Construtor padrão
    public Cliente() {
    }

    // Construtor com parâmetros
    public Cliente(String nome) {
        this.nome = nome;
    }

    // Getters e setters

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

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    public Calendar getDataNascimentoCliente() {
        return dataNascimentoCliente;
    }

    public void setDataNascimentoCliente(Calendar dataNascimentoCliente) {
        this.dataNascimentoCliente = dataNascimentoCliente;
    }

    public String getGeneroCliente() {
        return generoCliente;
    }

    public void setGeneroCliente(String generoCliente) {
        this.generoCliente = generoCliente;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public List<Avaliacao> getAvaliacoes() {
        return avaliacoes;
    }

    public void setAvaliacoes(List<Avaliacao> avaliacoes) {
        this.avaliacoes = avaliacoes;
    }
}
