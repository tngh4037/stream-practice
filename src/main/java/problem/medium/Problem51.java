package problem.medium;

import java.util.Comparator;
import java.util.List;
import problem.medium.resources.Employee;

public class Problem51 {

    /**
     * 주어진 직원(Employee) 리스트에서 'IT' 부서에 속하고,
     * 나이가 30 이상인 직원들의 이름을 알파벳 순으로 정렬하여 반환합니다.
     *
     * @param employees 직원 리스트
     * @return 조건을 만족하는 직원들의 이름 리스트
     */
    public static List<String> getNamesOfITDepartmentEmployeesOver30(List<Employee> employees) {
        // 여기에 코드 작성
        return employees.stream()
                .filter(emp -> emp.getDepartment().equals("IT") && emp.getAge() >= 30)
                .map(Employee::getName)
                .sorted(Comparator.naturalOrder())
                .toList();
    }
}