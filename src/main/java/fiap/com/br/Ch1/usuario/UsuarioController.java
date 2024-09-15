package fiap.com.br.Ch1.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository userRepo;

    // Listar Usuários
    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = (List<Usuario>) userRepo.findAll();
        model.addAttribute("usuarios", usuarios);
        return "usuarios";  // Thymeleaf irá procurar por um template chamado "usuarios.html"
    }

    // Exibir Formulário de Criação
    @GetMapping("/novo")
    public String exibirFormularioCriacao(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "form-usuario";  // Thymeleaf irá procurar por um template chamado "form-usuario.html"
    }

    // Criar ou Atualizar Usuário
    @PostMapping("/salvar")
    public String salvarUsuario(@Valid @ModelAttribute Usuario usuario) {
        userRepo.save(usuario);
        return "redirect:/usuarios";  // Redireciona de volta para a página de listagem de usuários
    }

    // Exibir Formulário de Edição
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = userRepo.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "form-usuario";  // Reutiliza o formulário de criação para edição
        } else {
            return "redirect:/usuarios";  // Se o usuário não for encontrado, redireciona para a listagem
        }
    }

    // Excluir Usuário
    @GetMapping("/excluir/{id}")
    public String excluirUsuario(@PathVariable Long id) {
        userRepo.deleteById(id);
        return "redirect:/usuarios";
    }

    // Consultar Usuário por ID
    @GetMapping("/{id}")
    public String consultarUsuarioPorId(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = userRepo.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuario-detalhes";  // Exibe os detalhes do usuário em um novo template
        } else {
            return "redirect:/usuarios";
        }
    }
}
