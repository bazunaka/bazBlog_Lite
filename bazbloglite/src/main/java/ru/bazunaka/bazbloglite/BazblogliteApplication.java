package ru.bazunaka.bazbloglite;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BazblogliteApplication {

    public static void main(String[] args) {
        SpringApplication.run(BazblogliteApplication.class, args);
    }

}
