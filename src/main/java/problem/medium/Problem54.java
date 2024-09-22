package problem.medium;

import java.util.Comparator;
import java.util.List;
import problem.medium.resources.Product;

public class Problem54 {

    /**
     * 주어진 제품(Product) 리스트에서 가장 높은 가격을 가진 제품의 이름을 반환합니다.
     * 리스트가 비어있다면 빈 문자열을 반환합니다.
     *
     * @param products 제품 리스트
     * @return 최대 가격을 가진 제품의 이름, 빈 리스트인 경우 빈 문자열
     */
    public static String getMostExpensiveProductName(List<Product> products) {
        // 여기에 코드 작성
        return products.stream()
                .max(Comparator.comparingDouble(Product::getPrice))
                .map(v -> v.getName())
                .orElse("");

        // return products.stream()
        //         .sorted(Comparator.comparing(Product::getPrice, Comparator.reverseOrder()))
        //         .findFirst()
        //         .map(v -> v.getName())
        //         .orElse("");
    }
}
