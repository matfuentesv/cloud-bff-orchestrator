package cl.veterinary.cloudbfforchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CloudBffOrchestratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CloudBffOrchestratorApplication.class, args);
    }

}
