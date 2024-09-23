package problem.medium;

import java.util.Comparator;
import java.util.List;

import problem.medium.resources.Customer2;
import problem.medium.resources.Order;

// 다시보기
public class Problem55 {

    /**
     * 주어진 고객(Customer2) 리스트에서 'Bread' 제품을 가장 많이 주문한 고객의 이름을 반환합니다.
     * 동일한 수량을 주문한 고객이 여럿이면, 그 중 하나의 이름을 반환합니다.
     *
     * @param customers 고객 리스트
     * @return 'Bread' 제품을 가장 많이 주문한 고객의 이름
     */
    public static String getCustomerWhoOrderedMostBread(List<Customer2> customers) {
        // 여기에 코드 작성
        return  customers.stream()
                .map(customer -> new java.util.AbstractMap.SimpleEntry<>(
                        customer.getName(),
                        customer.getOrders().stream()
                                .filter(order -> "Bread".equals(order.getProduct()))
                                .mapToInt(Order::getQuantity)
                                .sum()))
                .filter(entry -> entry.getValue() > 0)
                .max(Comparator.comparingInt(java.util.AbstractMap.SimpleEntry::getValue))
                .map(java.util.AbstractMap.SimpleEntry::getKey)
                .orElse(null);
    }
}

// [ SimpleEntry ]
// : SimpleEntry 는 Java의 AbstractMap 클래스 내부에 정의된 정적 클래스입니다. 이 클래스는 키-값 쌍을 쉽게 저장하고 조작할 수 있게 해줍니다.
//
// 사용 목적)
// 주로 다음과 같은 용도로 사용됩니다.
// - 키-값 쌍을 저장: 데이터 구조를 만들 필요 없이 간단하게 키와 값을 한 쌍으로 저장할 수 있습니다.
// - Stream API와의 통합: 스트림에서 키-값 쌍을 처리할 때 유용하게 사용할 수 있습니다.
//
// ex) 예를 들어, SimpleEntry를 사용하여 고객 이름과 해당 고객의 'Bread' 주문 수량을 함께 묶어 처리할 수 있습니다.
// import java.util.AbstractMap.SimpleEntry;
//
// // 고객 이름과 'Bread' 주문 수량을 매핑
// SimpleEntry<String, Integer> entry = new SimpleEntry<>("Alice", 5);
// String customerName = entry.getKey(); // "Alice"
// Integer breadCount = entry.getValue(); // 5
//
// SimpleEntry는 스트림에서 처리할 때 유용하게 사용할 수 있는 간단한 도구로, 코드의 가독성을 높이고 복잡한 데이터 구조를 피할 수 있게 도와줍니다.
//
//
// 참고) HashMap 등을 사용해도 되는데 굳이 왜 SimpleEntry 를 사용 ?
// - 1) 간단한 키-값 쌍: SimpleEntry는 두 개의 값을 묶어서 쉽게 처리할 수 있도록 도와줍니다. 간단한 키-값 쌍이 필요할 때 별도의 클래스를 정의할 필요 없이 사용할 수 있습니다.
// - 2) 메모리 효율성: HashMap과 같은 복잡한 자료구조는 여러 기능(예: 해시 충돌 처리, 키-값 쌍의 저장)을 가지고 있지만, SimpleEntry는 그저 두 개의 값만 저장합니다. 따라서 더 적은 메모리를 사용합니다.
// - 3) 직관적인 코드: SimpleEntry를 사용하면 코드가 더 간결해지고 가독성이 높아집니다. 특히 Stream API와 함께 사용할 때 간단하게 데이터를 처리할 수 있습니다.
// - 4) 불필요한 복잡성 제거: 특정한 경우, 단순히 두 개의 관련된 값을 처리하는 것이 목적이라면, HashMap을 사용하는 것은 과한 설계일 수 있습니다. SimpleEntry는 이런 경우에 더 적합합니다.
// - 5) 함수형 프로그래밍: 함수형 프로그래밍 스타일의 코드에서 SimpleEntry는 쉽게 사용할 수 있으며, 람다 표현식과 함께 잘 어울립니다. 특히, Stream 처리 과정에서 키-값 쌍을 만들고 싶을 때 유용합니다.
//
// 예시 코드)
// import java.util.AbstractMap.SimpleEntry;
// import java.util.List;
// import java.util.stream.Collectors;
//
// public class Main {
//     public static void main(String[] args) {
//         List<String> words = List.of("apple", "banana", "cherry");
//
//         List<SimpleEntry<String, Integer>> wordLengths = words.stream()
//             .map(word -> new SimpleEntry<>(word, word.length()))
//             .collect(Collectors.toList());
//
//         wordLengths.forEach(entry ->
//             System.out.println("Word: " + entry.getKey() + ", Length: " + entry.getValue()));
//     }
// }
//
// 결론)
// : SimpleEntry는 간단하고 효율적으로 두 개의 관련된 값을 저장하고 사용할 수 있는 방법을 제공합니다. 필요에 따라 적절한 자료구조를 선택하는 것이 중요하지만, 간단한 키-값 쌍을 처리할 때는 SimpleEntry가 유용할 수 있습니다.