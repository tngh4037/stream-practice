package problem.hard;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// ? [1, 2, 3, 4, 7] -> [1, 2, 3, 4]
public class Problem74 {

    /**
     * 주어진 정수 리스트에서 순차적으로 증가하는 숫자들의 최대 길이 서브리스트를 찾습니다.
     * 예를 들어, [1, 2, 5, 3, 4, 7, 6]의 경우 [1, 2, 3, 4, 7]이 됩니다.
     *
     * @param numbers 정수 리스트
     * @return 순차적으로 증가하는 숫자들의 최대 길이 서브리스트
     */
    public static List<Integer> findLongestSequentiallyIncreasingSublist(List<Integer> numbers) {
        // 여기에 코드 작성
        return IntStream.range(0, numbers.size() - 1)
                .filter(i -> numbers.get(i) < numbers.get(i + 1))
                .map(i -> numbers.get(i))
                .boxed()
                .collect(Collectors.toList());
    }
}
