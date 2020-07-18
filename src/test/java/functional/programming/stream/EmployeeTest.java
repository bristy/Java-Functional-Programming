package functional.programming.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertThat;

public class EmployeeTest {
    @Test
    public void testForEach() {
        final List<Employee> testEmployees = Arrays.asList(
                new Employee(1, "test1", 100.0),
                new Employee(2, "test2", 200.0)
        );
        testEmployees.stream().forEach(employee -> employee.incrementSalary(100));

        assertThat(testEmployees, contains(
                hasProperty("salary", equalTo(200.0)),
                hasProperty("salary", equalTo(300.0))
        ));
    }

    @Test
    public void testMap() {
        final Integer[] empIds = {1, 2, 3};
        final List<Employee> testEmployees = Arrays.asList(empIds).stream()
                .map(id -> new Employee(id, "test" + id, 0.0))
                .collect(Collectors.toList());
        assertThat(testEmployees, contains(
                hasProperty("id", equalTo(1)),
                hasProperty("id", equalTo(2)),
                hasProperty("id", equalTo(3))
        ));
    }

    @Test
    public void testFilter() {
        final Integer[] empIds = {1, 2, 3, 4};
        final List<Employee> testEmployees = Arrays.asList(empIds).stream()
                .map(id -> new Employee(id, "test" + id, 10000.0 * id))
                .filter(employee -> employee.getSalary() > 20000.0)
                .collect(Collectors.toList());

        assertThat(testEmployees, hasSize(equalTo(2)));
        assertThat(testEmployees, contains(
                hasProperty("salary", greaterThan(20000.0)),
                hasProperty("salary", greaterThan(20000.0))
        ));
    }
}
