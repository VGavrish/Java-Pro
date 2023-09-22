package HomeWork33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "org.HomeWork33")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}