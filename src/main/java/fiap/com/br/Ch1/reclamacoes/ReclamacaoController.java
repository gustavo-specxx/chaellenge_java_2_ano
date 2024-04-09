package fiap.com.br.Ch1.reclamacoes;

import fiap.com.br.Ch1.usuario.Usuario;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/Reclamacao")
public class ReclamacaoController {

    private List<Reclamacao> reclamacoes = new ArrayList<>();
    //Funções CRUD (Create, Read, Update and Delete)
//Funções PGPD (Post, Get, Put and Delete) - DB
//Função: Read - Geral
    @GetMapping
    public List<Reclamacao> listareclamacoes() {
        return reclamacoes;
    }
    //Função: Create
    @PostMapping
    public Reclamacao criarReclamacao(@RequestBody Reclamacao reclamacao) {
        reclamacao.setId(generateNextId()); // atribui um ID único
        reclamacoes.add(reclamacao);
        return reclamacao;
    }
    //Função: Update
    @PutMapping("/{id}")
    public Reclamacao atualizarReclamacao(@PathVariable Long id, @RequestBody Reclamacao reclamacao) {
        Reclamacao reclamacaoExistente = reclamacoes.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Reclamação não encontrado"));
        reclamacaoExistente.setReclamacoes(reclamacao.getReclamacoes());
// atualize outros atributos se necessário
        return reclamacaoExistente;
    }
    //Função: Delete
    @DeleteMapping("/{id}")
    public void excluirReclamacao(@PathVariable Long id) {
        reclamacoes.removeIf(u -> u.getId().equals(id));
    }
    //Função: Read - ID específico
    @GetMapping("/{id}")
    public Reclamacao consultarReclamacaoPorId(@PathVariable Long id) {
        return reclamacoes.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Reclamação não encontrada"));
    }
    private Long generateNextId() {
        Long maxId = reclamacoes.stream()
                .mapToLong(Reclamacao::getId)
                .max()
                .orElse(0L);
        return maxId + 1;
    }
}