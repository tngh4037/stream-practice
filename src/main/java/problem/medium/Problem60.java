package problem.medium;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import problem.medium.resources.Customer2;
import problem.medium.resources.Employee;
import problem.medium.resources.Product;

// 다시보기
public class Problem60 {

    /**
     * 주어진 고객(Customer) 리스트와 직원(Employee) 리스트를 사용하여,
     * 'IT' 부서 직원들이 주문한 'Electronics' 제품의 총 가격을 계산합니다.
     * 이때, 고객 이름과 직원 이름이 일치하는 경우에만 해당 고객의 주문을 고려합니다.
     *
     * @param customers 고객 리스트
     * @param employees 직원 리스트
     * @param products 제품 리스트 (제품 이름과 가격 정보 포함)
     * @return 'IT' 부서 직원들이 주문한 'Electronics' 제품의 총 가격
     */
    public static double calculateTotalPriceOfElectronicsOrderedByITEmployees(List<Customer2> customers,
                                                                              List<Employee> employees,
                                                                              List<Product> products) {

        List<String> empNames = employees.stream().filter(e -> e.getDepartment().equals("IT")).map(e -> e.getName()).toList();

        Map<String, Double> electronics = products.stream()
                .filter(p -> p.getName().equals("Laptop") || p.getName().equals("Smartphone"))
                .collect(Collectors.toMap(Product::getName, Product::getPrice));

        // 여기에 코드 작성
        return customers.stream()
                .filter(customer -> empNames.contains(customer.getName()))
                .flatMap(customer -> customer.getOrders().stream())
                .filter(order -> electronics.containsKey(order.getProduct()))
                .mapToDouble(order -> electronics.get(order.getProduct()) * order.getQuantity())
                .sum();
    }
}
