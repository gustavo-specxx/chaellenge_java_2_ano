package fiap.com.br.Ch1.usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/chatgpt")
public class ChatGPTController {

    private final ChatGPTService chatGPTService;

    public ChatGPTController(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    @GetMapping
    public String exibirFormularioChat(Model model) {
        model.addAttribute("mensagem", "");
        model.addAttribute("resposta", "");
        return "chatgpt";
    }

    @PostMapping("/enviar")
    public String enviarMensagem(@RequestParam("mensagem") String mensagem, Model model) {
        // Criar uma lista de produtos recomendados para passar para o método
        List<Produto> produtosRecomendados = new ArrayList<>();
        produtosRecomendados.add(new Produto("Produto A", 100));
        produtosRecomendados.add(new Produto("Produto B", 150));

        // Chamar o método com a mensagem e a lista de produtos
        String resposta = chatGPTService.gerarRecomendacao(mensagem, produtosRecomendados);

        model.addAttribute("resposta", resposta);
        model.addAttribute("mensagem", mensagem);
        return "chatgpt";
    }
}
