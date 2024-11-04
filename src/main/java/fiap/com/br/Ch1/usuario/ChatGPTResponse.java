package fiap.com.br.Ch1.usuario;

import java.util.List;
import java.util.Map;

public class ChatGPTResponse {
    private List<Map<String, Object>> choices;

    public ChatGPTResponse() {}

    public ChatGPTResponse(String errorMessage) {
        this.choices = List.of(Map.of("message", Map.of("content", errorMessage)));
    }

    public List<Map<String, Object>> getChoices() {
        return choices;
    }

    public void setChoices(List<Map<String, Object>> choices) {
        this.choices = choices;
    }

    public String getResponseContent() {
        return choices.get(0).get("message").toString(); // Ou adapte conforme a estrutura real
    }
}
