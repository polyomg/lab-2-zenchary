package poly.edu.ts01154lab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"poly.edu.ts01154lab2","Controller"})
@SpringBootApplication
public class Ts01154Lab2Application {

    public static void main(String[] args) {
        SpringApplication.run(Ts01154Lab2Application.class, args);
    }

}
