package fiap.com.br.Ch1.usuario;



import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EntityScan("fiap.com.br.Ch1")
@EnableJpaRepositories("fiap.com.br.Ch1")
public class ServidorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServidorApplication.class, args);
    }

}
