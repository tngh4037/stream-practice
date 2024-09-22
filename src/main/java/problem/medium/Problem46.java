package problem.medium;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 다시보기
public class Problem46 {

    /**
     * 주어진 정수 리스트에서 각 숫자의 출현 빈도를 계산하여 Map으로 반환합니다.
     *
     * @param numbers 정수 리스트
     * @return 각 숫자의 출현 빈도를 나타내는 Map
     */
    public static Map<Integer, Long> frequencyOfNumbers(List<Integer> numbers) {
        // 여기에 코드 작성
        return numbers.stream()
                .collect(Collectors.groupingBy(
                        Integer::intValue,
                        Collectors.counting()
                ));

        // return numbers.stream()
        //         .collect(Collectors.toMap(num -> num, num -> 1L, Long::sum));
    }
}
