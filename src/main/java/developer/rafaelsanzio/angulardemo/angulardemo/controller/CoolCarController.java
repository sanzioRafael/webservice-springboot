package developer.rafaelsanzio.angulardemo.angulardemo.controller;

import developer.rafaelsanzio.angulardemo.angulardemo.model.Car;
import developer.rafaelsanzio.angulardemo.angulardemo.repository.CarRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.stream.Collectors;

@RestController
public class CoolCarController {

    private CarRepository carRepository;

    public CoolCarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cool-cars")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<Car> coolCars() {
        return carRepository.findAll().stream()
                .filter(this::isCool)
                .collect(Collectors.toList());
    }

    private boolean isCool(Car car) {
        return !car.getName().equals("AMC Gremlin") &&
                !car.getName().equals("Triumph Stag") &&
                !car.getName().equals("Ford Pinto") &&
                !car.getName().equals("Yugo GV");
    }
}
