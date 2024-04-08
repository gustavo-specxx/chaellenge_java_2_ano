package fiap.com.br.Ch1.reclamacoes;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamacaoResository  extends CrudRepository<Reclamacao, Long>{
}
