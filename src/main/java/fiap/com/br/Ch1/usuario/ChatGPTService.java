package fiap.com.br.Ch1.usuario;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;

import java.util.List;
import java.util.Map;

@Service
public class ChatGPTService {

    private final WebClient webClient;

    @Value("${openai.api.key}")
    private String apiKey;

    public ChatGPTService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.openai.com/v1").build();
    }

    public String gerarRecomendacao(String descricaoProduto, List<Produto> produtosRecomendados) {
        try {
            // Constrói o prompt para recomendar produtos
            String prompt = "Com base no seguinte produto: \"" + descricaoProduto + "\", recomende produtos semelhantes entre estes: "
                    + produtosRecomendados.stream()
                    .map(p -> p.getNome() + " (Preço: " + p.getPreco() + ")")
                    .reduce((p1, p2) -> p1 + ", " + p2)
                    .orElse("Nenhum produto semelhante encontrado");

            // Cria o payload para a solicitação da API
            Map<String, Object> request = Map.of(
                    "model", "gpt-3.5-turbo",
                    "messages", List.of(Map.of("role", "user", "content", prompt)),
                    "max_tokens", 150
            );

            // Faz a chamada POST para a API do OpenAI
            String response = webClient.post()
                    .uri("/chat/completions")
                    .header("Authorization", "Bearer " + apiKey)
                    .header("Content-Type", "application/json")
                    .bodyValue(request)
                    .retrieve()
                    .bodyToMono(String.class)
                    .block();

            // Processa a resposta JSON da API do OpenAI
            ObjectMapper mapper = new ObjectMapper();
            @SuppressWarnings("unchecked")
            Map<String, Object> responseMap = mapper.readValue(response, Map.class);
            @SuppressWarnings("unchecked")
            List<Map<String, Object>> choices = (List<Map<String, Object>>) responseMap.get("choices");

            if (choices != null && !choices.isEmpty()) {
                @SuppressWarnings("unchecked")
                Map<String, Object> message = (Map<String, Object>) choices.get(0).get("message");
                return message.get("content").toString();
            }

            return "Sem resposta do modelo.";
        } catch (WebClientResponseException e) {
            return "Erro ao chamar a API do OpenAI: " + e.getMessage();
        } catch (Exception e) {
            return "Erro inesperado: " + e.getMessage();
        }
    }
}
