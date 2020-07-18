package functional.programming.stream;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private @NonNull Integer id;
    private @NonNull String name;
    private @NonNull Double salary;

    public void incrementSalary(double salary) {
        this.salary += salary;
    }
}
