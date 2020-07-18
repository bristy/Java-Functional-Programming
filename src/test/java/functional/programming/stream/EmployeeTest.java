package functional.programming.stream;

import static org.hamcrest.Matchers.contains;

import functional.programming.stream.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.junit.Assert.assertThat;

public class EmployeeTest {
    @Test public void testIncrementSalary() {
        List<Employee> testEmployees = getTestEmployee();
        testEmployees.stream().forEach(employee -> employee.incrementSalary(100));

        assertThat(testEmployees, contains(
                hasProperty("salary", equalTo(200.0)),
                hasProperty("salary", equalTo(300.0))
        ));
    }

    private List<Employee> getTestEmployee() {
        return Arrays.asList(
                new Employee("test1", 100.0),
                new Employee("test2", 200.0)
        );
    }
}
