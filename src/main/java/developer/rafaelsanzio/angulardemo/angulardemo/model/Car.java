package developer.rafaelsanzio.angulardemo.angulardemo.model;

import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    @NonNull
    private String name;

    public Car() {
    }
}
