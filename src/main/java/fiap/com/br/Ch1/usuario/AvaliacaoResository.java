package fiap.com.br.Ch1.usuario;

import fiap.com.br.Ch1.usuario.Avaliacao;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvaliacaoResository  extends CrudRepository<Avaliacao, Long>{
}
