package problem.medium;

import java.util.Collections;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;

// 다시보기
public class Problem36 {

    /**
     * 주어진 정수 리스트에서 연속된 3개의 숫자가 모두 짝수인 첫 번째 연속 부분을 찾습니다.
     * 만약 해당하는 부분이 없다면 빈 리스트를 반환합니다.
     *
     * @param numbers 정수 리스트
     * @return 연속된 3개의 숫자가 모두 짝수인 첫 번째 부분의 리스트
     */
    public static List<Integer> findFirstTripleEvenSequence(List<Integer> numbers) {
        // 여기에 코드 작성
        OptionalInt firstEvenIndex = IntStream.range(0, numbers.size() - 2)
                .filter(i -> numbers.get(i) % 2 == 0
                        && numbers.get(i + 1) % 2 == 0
                        && numbers.get(i + 2) % 2 == 0)
                .findFirst();

        if (firstEvenIndex.isPresent()) {
            int i = firstEvenIndex.getAsInt();
            return numbers.subList(i, i + 3);
        } else {
            return Collections.emptyList();
        }
    }
}
