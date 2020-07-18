package functional.programming.stream;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class EmployeeTest {
    @Test public void testIncrementSalary() {
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

    @Test public void testEmployeeIdsToEmployee() {
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
}
