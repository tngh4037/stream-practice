package problem.medium;

import java.util.Comparator;
import java.util.List;

// 다시보기
public class Problem34 {

    /**
     * 주어진 정수 리스트에서 최대값을 찾습니다. 리스트가 비어있으면 0을 반환합니다.
     *
     * @param numbers 정수 리스트
     * @return 리스트의 최대값, 리스트가 비어 있으면 0
     */
    public static int findMaxValue(List<Integer> numbers) {
        // 여기에 코드 작성
        return numbers.stream()
                .max(Integer::compareTo)
                .orElse(0);

        //return numbers.stream()
        //        .max(Comparator.naturalOrder())
        //        .orElse(0);
    }
}
