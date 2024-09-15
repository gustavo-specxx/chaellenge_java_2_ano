package fiap.com.br.Ch1.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoResository avarepo;

    // Listar Avaliações
    @GetMapping
    public String listarAvaliacoes(Model model) {
        List<Avaliacao> avaliacoes = (List<Avaliacao>) avarepo.findAll();
        model.addAttribute("avaliacoes", avaliacoes);
        return "avaliacoes";  // Thymeleaf irá procurar por um template chamado "avaliacoes.html"
    }

    // Exibir Formulário de Criação
    @GetMapping("/novo")
    public String exibirFormularioCriacao(Model model) {
        model.addAttribute("avaliacao", new Avaliacao());
        return "form-avaliacao";  // Thymeleaf irá procurar por um template chamado "form-avaliacao.html"
    }

    // Criar ou Atualizar Avaliação
    @PostMapping("/salvar")
    public String salvarAvaliacao(@Valid @ModelAttribute Avaliacao avaliacao) {
        avarepo.save(avaliacao);
        return "redirect:/avaliacoes";  // Redireciona de volta para a página de listagem de avaliações
    }

    // Exibir Formulário de Edição
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Optional<Avaliacao> avaliacao = avarepo.findById(id);
        if (avaliacao.isPresent()) {
            model.addAttribute("avaliacao", avaliacao.get());
            return "form-avaliacao";  // Reutiliza o formulário de criação para edição
        } else {
            return "redirect:/avaliacoes";  // Se a avaliação não for encontrada, redireciona para a listagem
        }
    }

    // Excluir Avaliação
    @GetMapping("/excluir/{id}")
    public String excluirAvaliacao(@PathVariable Long id) {
        avarepo.deleteById(id);
        return "redirect:/avaliacoes";
    }

    // Consultar Avaliação por ID
    @GetMapping("/{id}")
    public String consultarAvaliacaoPorId(@PathVariable Long id, Model model) {
        Optional<Avaliacao> avaliacao = avarepo.findById(id);
        if (avaliacao.isPresent()) {
            model.addAttribute("avaliacao", avaliacao.get());
            return "avaliacao-detalhes";  // Exibe os detalhes da avaliação em um novo template
        } else {
            return "redirect:/avaliacoes";
        }
    }
}
