
package fiap.com.br.Ch1.usuario;


import java.util.Calendar;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;



@Entity
@Table(name="TB_CLIENTE")
@SequenceGenerator(name = "CLI_SEQ", sequenceName = "TB_CLIENTE_SEQ", allocationSize = 1)
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CLI_SEQ")
    @Column(name="ID_CLIENTE")
    private Long id;

    @NotNull
    @Size(min=2, max=255)
    private String nome_cliente;

    @Email
    @Column(name="CPF_CLIENTE")
    private String cpfCliente; // Renomeado para seguir o padrão JavaBeans

    @NotNull
    @Column(name="DATA_NASCIMENTO_CLIENTE")
    private Calendar data_nascimento_cliente;

    @NotNull
    @Column(name="GENERO_CLIENTE")
    private String genero_cliente;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Produto> produtos;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Avaliacao> avaliacoes;

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }

    @JsonFormat(pattern = "dd/MM/yyyy")
    public Calendar getData_nascimento_cliente() {
        return data_nascimento_cliente;
    }

    public void setData_nascimento_cliente(Calendar data_nascimento_cliente) {
        this.data_nascimento_cliente = data_nascimento_cliente;
    }

    public String getGenero_cliente() {
        return genero_cliente;
    }

    public void setGenero_cliente(String genero_cliente) {
        this.genero_cliente = genero_cliente;
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