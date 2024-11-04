package fiap.com.br.Ch1.usuario;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecomendacaoService {

    private final ChatGPTService chatGPTService;

    public RecomendacaoService(ChatGPTService chatGPTService) {
        this.chatGPTService = chatGPTService;
    }

    public String recomendarProdutosComChatGPT(Produto produto) {
        // Cria uma lista de produtos que podem ser usados como produtos recomendados
        List<Produto> produtosRecomendados = List.of(
                new Produto("Produto Similar 1"),
                new Produto("Produto Similar 2")
        );

        // Chama o serviço de recomendação usando ChatGPT
        return chatGPTService.gerarRecomendacao(produto.getDescricao(), produtosRecomendados);
    }
}