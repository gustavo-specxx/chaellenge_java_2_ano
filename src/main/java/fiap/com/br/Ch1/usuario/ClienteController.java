
package fiap.com.br.Ch1.usuario;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository clirepo;

    @GetMapping
    public List<Cliente> listarClientes(){
        return clirepo.findAll();
    }

    @PostMapping
    public ResponseEntity<String> adicionarCliente(@RequestBody Cliente cliente) {
        try {
            // Verificar se o cliente já existe
            Cliente clienteExistente = clirepo.findByCpfCliente(cliente.getCpfCliente());
            if (clienteExistente != null) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente já existe");
            }

            // Definir o novo id_cliente e salvar o cliente
            clirepo.save(cliente);

            return ResponseEntity.ok("Cliente criado com sucesso");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao adicionar cliente: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> excluirCliente(@PathVariable Long id) {
        try {
            clirepo.deleteById(id);
            return ResponseEntity.ok("Cliente eliminado com sucesso");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao remover cliente: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarClientePorId(@PathVariable Long id) {
        try {
            Optional<Cliente> clienteOptional = clirepo.findById(id);
            if (clienteOptional.isPresent()) {
                return ResponseEntity.ok(clienteOptional.get());
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Cliente com o ID " + id + " não encontrado");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao consultar cliente por ID: " + e.getMessage());
        }
    }
}