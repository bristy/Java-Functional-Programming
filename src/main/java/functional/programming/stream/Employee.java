package functional.programming.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private String name;
    private Double salary = 0.0d;

    public Employee() {
    }

    public void incrementSalary(double salary) {
        this.salary += salary;
    }
}
