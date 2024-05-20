package fiap.com.br.Ch1.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository userRepo;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastrarUsuario(@Valid @RequestBody Usuario usuario) {
        try {
            // Verificar se o usuário já existe
            Optional<Usuario> usuarioExistente = userRepo.findByEmail(usuario.getEmail());
            if (usuarioExistente.isPresent()) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Usuário já existe");
            }

            // Salvar o novo usuário
            userRepo.save(usuario);

            return ResponseEntity.ok("Usuário cadastrado com sucesso");

        } catch (Exception e) {
            // Registra o erro em logs para depuração posterior
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar usuário. Por favor, tente novamente mais tarde.");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String> loginUsuario(@Valid @RequestBody Usuario usuario) {
        try {
            Optional<Usuario> usuarioExistente = userRepo.findByEmail(usuario.getEmail());
            if (usuarioExistente.isEmpty()) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("E-mail ou senha incorretos");
            }
            return ResponseEntity.ok("Login realizado com sucesso");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao realizar login: " + e.getMessage());
        }
    }
}