package problem.hard;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

// 다시보기
public class Problem70 {

    /**
     * 주어진 정수 리스트에서 각 숫자의 소수 여부를 판별하고, 리스트 내 최대 소수를 찾습니다.
     * 결과는 각 숫자의 소수 여부와 리스트 내 최대 소수를 포함하는 Map으로 반환합니다.
     *
     * @param numbers 정수 리스트
     * @return 각 숫자의 소수 여부와 최대 소수를 포함하는 Map
     */
    public static Map<Object, Object> identifyPrimesAndFindMax(List<Integer> numbers) {
        // 여기에 코드 작성

        // 방법1)
        // 최대 소수 찾기
        Optional<Integer> maxPrime = numbers.stream()
                .filter(Problem70::isPrime)
                .max(Integer::compareTo);

        // 숫자의 소수 여부 맵 생성
        Map<Object, Object> primeMap = numbers.stream()
                .collect(Collectors.toMap(
                        num -> num,
                        num -> isPrime(num) ? "Prime" : "Not Prime",
                        (existing, replacement) -> existing // 중복된 키 처리
                ));

        // 최대 소수를 맵에 추가
        maxPrime.ifPresentOrElse(
                prime -> primeMap.put("Max Prime", prime),
                () -> primeMap.put("Max Prime", "None") // 소수가 없는 경우
        );

        return primeMap;

        // 방법2)
        // Map<Object, Object> nums = numbers.stream()
        //         .collect(Collectors.toMap(
        //                 num -> num,
        //                 num -> checkPrime(num),
        //                 (existing, replacement) -> existing // 중복된 키 처리
        //         ));

        // nums.put("Max Prime",
        //         nums.entrySet().stream()
        //                 .filter(entry -> entry.getValue().equals("Prime"))
        //                 .max(Comparator.comparingInt(entry -> (int) entry.getKey()))
        //                 .map(entry -> entry.getKey())
        //                 .orElse("None"));

        // return nums;
    }

    private static String checkPrime(int n) {
        if (n <= 1) return "Not Prime";

        int sqrt = (int) Math.sqrt(n);
        for (int i = 2; i <= sqrt; i++) {
            if (n % i == 0) {
                return "Not Prime";
            }
        }
        return "Prime";
    }

    // 소수 판별 함수
    private static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}

//  Map<Object, Object> expected = Map.of(
//          2, "Prime",
//          3, "Prime",
//          4, "Not Prime",
//          "Max Prime", 3
//  );