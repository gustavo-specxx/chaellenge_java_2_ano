package fiap.com.br.Ch1.usuario;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository Userrepo;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrarUsuario(@RequestBody Usuario usuario) {
        try {
            // Verificar se o usuário já existe
            Usuario usuarioExistente = Userrepo.findByEmail(usuario.getEmail());
            if (usuarioExistente != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
            }

            // Salvar o novo usuário
            Userrepo.save(usuario); // Aqui ocorre o erro

            return ResponseEntity.ok("Usuário cadastrado com sucesso");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@RequestBody Usuario usuario) {
        try {
            Usuario usuarioExistente = Userrepo.findByEmail(usuario.getEmail());
            if (usuarioExistente == null || !usuarioExistente.getSenha().equals(usuario.getSenha())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("E-mail ou senha incorretos");
            }

            return ResponseEntity.ok("Login realizado com sucesso");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar login: " + e.getMessage());
        }
    }
}
