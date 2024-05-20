package fiap.com.br.Ch1.usuario;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table(name = "TB_AUTENTICA")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_seq")
    @SequenceGenerator(name = "usuario_seq", sequenceName = "usuario_seq", allocationSize = 1)
    @Column(name = "ID_AUTENTICA")
    private Long id;

    @NotNull(message = "O e-mail do usuário é obrigatório")
    @Email
    @JsonProperty("email_cliente")
    @Column(name = "EMAIL_CLIENTE", nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "SENHA_CLIENTE")
    private String senha;


    // Getters e setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
