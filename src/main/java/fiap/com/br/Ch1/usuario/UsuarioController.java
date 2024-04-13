
package fiap.com.br.Ch1.usuario;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private List<Usuario> usuarios = new ArrayList<>();

    //Funções CRUD (Create, Read, Update and Delete)
    //Funções PGPD (Post, Get, Put and Delete) - DB

    //Função: Read - Geral
    @Autowired
    private UsuarioRepository usua;
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usua.findAll();
    }

    //Função: Create
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        usuario.setId(generateNextId()); // atribui um ID único
        usuarios.add(usuario);
        return usuario;
    }

    //Função: Update
    @PutMapping("/{id}")
    public Usuario atualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario usuarioExistente = usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        usuarioExistente.setNome(usuario.getNome());
        // atualize outros atributos se necessário

        return usuarioExistente;
    }

    //Função: Delete
    @DeleteMapping("/{id}")
    public void excluirUsuario(@PathVariable Long id) {
        usuarios.removeIf(u -> u.getId().equals(id));
    }

    //Função: Read - ID específico
    @GetMapping("/{id}")
    public Usuario consultarUsuarioPorId(@PathVariable Long id) {
        return usuarios.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    private Long generateNextId() {
        Long maxId = usuarios.stream()
                .mapToLong(Usuario::getId)
                .max()
                .orElse(0L);
        return maxId + 1;
    }
}
