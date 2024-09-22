package problem.medium;

import java.util.List;
import problem.medium.resources.Customer2;
import problem.medium.resources.Order;

public class Problem53 {

    /**
     * 주어진 고객(Customer2) 리스트에서 각 고객별로 주문한 'Milk' 제품의 총 수량을 계산합니다.
     *
     * @param customers 고객 리스트
     * @return 각 고객별 'Milk' 제품의 총 주문 수량을 나타내는 리스트
     */
    public static List<String> getTotalMilkOrdersForEachCustomer(List<Customer2> customers) {
        // 여기에 코드 작성
        return customers.stream()
                .map(customer2 -> {
                    int sum = customer2.getOrders().stream()
                            .filter(order -> order.getProduct().equals("Milk"))
                            .mapToInt(Order::getQuantity)
                            .sum();

                    return customer2.getName() + ": " + sum;
                }).toList();
    }
}

// 참고) List<String> expected = Arrays.asList("Alice: 2", "Bob: 3");