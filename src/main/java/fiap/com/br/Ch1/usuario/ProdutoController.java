package fiap.com.br.Ch1.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepo;

    @Autowired
    private RecomendacaoService recomendacaoService;

    // Listar Produtos
    @GetMapping
    public String listarProdutos(Model model) {
        List<Produto> produtos = (List<Produto>) produtoRepo.findAll();
        model.addAttribute("produtos", produtos);
        return "produtos";  // Thymeleaf irá procurar por um template chamado "produtos.html"
    }

    // Exibir Formulário de Criação
    @GetMapping("/novo")
    public String exibirFormularioCriacao(Model model) {
        model.addAttribute("produto", new Produto());
        return "form-produto";  // Thymeleaf irá procurar por um template chamado "form-produto.html"
    }

    // Criar ou Atualizar Produto
    @PostMapping("/salvar")
    public String salvarProduto(@ModelAttribute Produto produto) {
        produtoRepo.save(produto);
        return "redirect:/produtos";  // Redireciona de volta para a página de listagem de produtos
    }

    // Exibir Formulário de Edição
    @GetMapping("/editar/{id}")
    public String exibirFormularioEdicao(@PathVariable Long id, Model model) {
        Optional<Produto> produto = produtoRepo.findById(id);
        if (produto.isPresent()) {
            model.addAttribute("produto", produto.get());
            return "form-produto";  // Reutiliza o formulário de criação para edição
        } else {
            return "redirect:/produtos";  // Se o produto não for encontrado, redireciona para a listagem
        }
    }

    // Excluir Produto
    @PostMapping("/excluir/{id}")
    public String excluirProduto(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        try {
            produtoRepo.deleteById(id);
            redirectAttributes.addFlashAttribute("message", "Produto excluído com sucesso.");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Erro ao excluir o produto.");
        }
        return "redirect:/produtos";
    }

    // Recomendação de Produtos
    @GetMapping("/{id}/recomendacoes")
    public String recomendarProdutos(@PathVariable Long id, Model model) {
        Produto produto = produtoRepo.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado: " + id));

        String recomendacao = recomendacaoService.recomendarProdutosComChatGPT(produto);

        model.addAttribute("produto", produto); // Adiciona informações do produto ao modelo para serem exibidas
        model.addAttribute("recomendacaoChatGPT", recomendacao); // Adiciona a recomendação ao modelo
        return "recomendacoes";  // Nome do template para exibir recomendações
    }
}
