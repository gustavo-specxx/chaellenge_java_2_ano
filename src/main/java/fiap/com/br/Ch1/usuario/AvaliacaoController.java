package fiap.com.br.Ch1.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoController {


    @Autowired
    private AvaliacaoResository avarepo;
    private List<Avaliacao> avaliacoes = new ArrayList<>();

    // Função: Read - Geral
    @GetMapping("/Listar")
    public List<Avaliacao> listarAvaliacoes(){
        return (List<Avaliacao>) avarepo.findAll();
    }

    // Função: Create
    @PostMapping
    public Avaliacao criarAvaliacao(@RequestBody Avaliacao avaliacao) {
        avaliacao.setIdAvaliacoes(generateNextId()); // atribui um ID único
        avaliacoes.add(avaliacao);
        return avaliacao;
    }


    // Função: Update
    @PutMapping("/{id}")
    public Avaliacao atualizarAvaliacao(@PathVariable Long id, @RequestBody Avaliacao novaAvaliacao) {
        Avaliacao avaliacaoExistente = avaliacoes.stream()
                .filter(a -> a.getIdAvaliacoes().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Avaliação não encontrada"));

        avaliacaoExistente.setIdAvaliacoes(novaAvaliacao.getIdAvaliacoes());
        // atualize outros atributos se necessário

        return avaliacaoExistente;
    }
    // Função: Delete
    @DeleteMapping("/{id}")
    public void excluirAvaliacao(@PathVariable Long id) {
        avaliacoes.removeIf(a -> a.getIdAvaliacoes().equals(id));
    }

    // Função: Read - ID específico
    @GetMapping("/{id}")
    public Avaliacao consultarAvaliacaoPorId(@PathVariable Long id) {
        return avaliacoes.stream()
                .filter(a -> a.getIdAvaliacoes().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Avaliação não encontrada"));
    }

    private Long generateNextId() {
        Long maxId = avaliacoes.stream()
                .mapToLong(Avaliacao::getIdAvaliacoes)
                .max()
                .orElse(0L);
        return maxId + 1;
    }
}
