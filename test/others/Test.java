package test.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    int id;
    int imp;
    List<Integer> subord;

    Employee(int id, int imp, List<Integer> subord) {
        this.id = id;
        this.imp = imp;
        this.subord = subord;
    }
}

public class Test {

    static Map<Integer, Employee> empMap = new HashMap<>();
    static int result = 0;
//  [[1, 3, [13]]]
    static long calculateImportance(List<Employee> input, int id) {
        loadEmpMap(input);
        totalImportance(id);
        return result;
    }

    static void totalImportance(int id) {
        Employee e = empMap.get(id);
        result += e.imp;
        for (int i : e.subord) {
            totalImportance(i);
        }
        return;
    }

    static void loadEmpMap(List<Employee> emp) {
        for (Employee employee : emp) {
            empMap.put(employee.id, employee);
        }
    }

    public static void main(String[] args) {
        List<Employee> input = new ArrayList<>();

        input.add(new Employee(1,5, Arrays.asList(2,3)));

        input.add(new Employee(2,3, Arrays.asList()));

        input.add(new Employee(3,3, Arrays.asList()));
        System.err.println("#############");
        System.out.println(calculateImportance(input, 1));
        System.err.println("#############");
    }

}
