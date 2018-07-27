package developer.rafaelsanzio.angulardemo.angulardemo;

import developer.rafaelsanzio.angulardemo.angulardemo.model.Car;
import developer.rafaelsanzio.angulardemo.angulardemo.repository.CarRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

import java.util.stream.Stream;

@EnableResourceServer
@SpringBootApplication
public class AngulardemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(AngulardemoApplication.class, args);
    }

    @Bean
    ApplicationRunner init(CarRepository repository) {
        return args -> {
            Stream.of("Ferrari", "Jaguar", "Prosche", "Lamborghini", "Bugatti",
                    "AMC Gremlin", "Triumph Stag", "Ford Pinto", "Yugo GV")
                    .forEach(name -> {
                        Car car = new Car();

                        car.setName(name);
                        repository.save(car);
                    });

            repository.findAll().forEach(System.out::println);
        };
    }
}
