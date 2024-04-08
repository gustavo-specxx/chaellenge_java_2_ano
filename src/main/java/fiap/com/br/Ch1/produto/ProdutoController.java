package fiap.com.br.Ch1.produto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/Produto")

public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtos;
    }

    //Função: Create
    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        produto.setId(generateNextId()); // atribui um ID único
        produtos.add(produto);
        return produto;
    }

    //Função: Update
    @PutMapping("/{id}")
    public Produto atualizarUsuario(@PathVariable Long id, @RequestBody Produto produto) {
        Produto ProdutoExistente = produtos.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));

        ProdutoExistente.setNome(produto.getNome());
        // atualize outros atributos se necessário

        return ProdutoExistente;
    }

    //Função: Delete
    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtos.removeIf(u -> u.getId().equals(id));
    }

    //Função: Read - ID específico
    @GetMapping("/{id}")
    public Produto consultarProdutoPorId(@PathVariable Long id) {
        return produtos.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Usuário não encontrado"));
    }

    private Long generateNextId() {
        Long maxId = produtos.stream()
                .mapToLong(Produto::getId)
                .max()
                .orElse(0L);
        return maxId + 1;
    }
}


