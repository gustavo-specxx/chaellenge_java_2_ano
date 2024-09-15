package fiap.com.br.Ch1.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByCpfCliente(String cpfCliente);

    @Query(value = "SELECT CLI_SEQ.NEXTVAL FROM DUAL", nativeQuery = true)
    Long proximoIdCliente();
}
