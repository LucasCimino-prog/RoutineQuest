package Api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"Api", "Data", "Model", "Utils"})

@EntityScan("Model")

@EnableJpaRepositories("Data")

public class RoutineQuestApplication {

    public static void main(String[] args) {
        SpringApplication.run(RoutineQuestApplication.class, args);
        System.out.println("=== Servidor Routine Quest Iniciado! ===");
        System.out.println("Escutando requisições na porta 8080...");
    }
}