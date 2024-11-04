package fiap.com.br.Ch1.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    @Query("SELECT p FROM Produto p WHERE p.tipo = :tipo AND ABS(p.preco - :preco) <= :precoRange AND p.id <> :id")
    List<Produto> findSimilarProducts(@Param("tipo") String tipo, @Param("preco") Integer preco, @Param("precoRange") Integer precoRange, @Param("id") Long id);
}
