package problem.hard;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem66 {

    /**
     * 주어진 정수 리스트에서 중복되지 않은 숫자들의 개수를 계산합니다.
     *
     * @param numbers 정수 리스트
     * @return 중복되지 않은 숫자들의 개수
     */
    public static long countUniqueNumbers(List<Integer> numbers) {
        // 여기에 코드 작성
        return numbers.stream()
                .distinct()
                .count();
    }
}

// 참고) 중복된 숫자의 갯수 구하기
//   // 숫자의 빈도를 계산
//   Map<Integer, Long> frequencyMap = numbers.stream()
//           .collect(Collectors.groupingBy(num -> num, Collectors.counting())); // downstream collector 는 그룹화된 결과에 대해 추가적인 처리나 집계를 수행하는 역할
//
//   // 빈도가 2 이상인 숫자의 개수를 반환
//   return frequencyMap.values().stream()
//           .filter(count -> count > 1)
//           .count();
