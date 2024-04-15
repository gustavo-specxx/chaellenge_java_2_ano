package fiap.com.br.Ch1.usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private List<Produto> produtos = new ArrayList<>();

    @Autowired
    private ProdutoRepository Productrepo;

    @GetMapping
    public List<Produto> produtoList(){
        return StreamSupport.stream(Productrepo.findAll().spliterator(), false)
                .collect(Collectors.toList());
    }


    // Criar Produto
    @PostMapping
    public Produto criarProduto(@RequestBody Produto produto) {
        produto.setId(generateNextId()); // Atribui um ID único
        produtos.add(produto);
        return produto;
    }

    // Atualizar Produto
    @PutMapping("/{id}")
    public Produto atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto produtoExistente = produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));

        produtoExistente.setNome(produto.getNome());
        produtoExistente.setDescricao(produto.getDescricao());
        // Atualize outros atributos, se necessário

        return produtoExistente;
    }

    // Excluir Produto
    @DeleteMapping("/{id}")
    public void excluirProduto(@PathVariable Long id) {
        produtos.removeIf(p -> p.getId().equals(id));
    }

    // Consultar Produto por ID
    @GetMapping("/{id}")
    public Produto consultarProdutoPorId(@PathVariable Long id) {
        return produtos.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado"));
    }

    // Método privado para gerar o próximo ID
    private Long generateNextId() {
        Long maxId = produtos.stream()
                .mapToLong(Produto::getId)
                .max()
                .orElse(0L);
        return maxId + 1;
    }
}
