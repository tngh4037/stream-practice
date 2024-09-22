package problem.medium;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// 다시보기
public class Problem40 {

    /**
     * 주어진 문자열 리스트를 문자열 길이에 따라 분류하여 Map으로 반환합니다.
     * Map의 키는 문자열의 길이이며, 값은 해당 길이를 가진 문자열의 리스트입니다.
     *
     * @param strings 문자열 리스트
     * @return 문자열의 길이를 키로, 해당 길이의 문자열 리스트를 값으로 가지는 Map
     */
    public static Map<Integer, List<String>> groupStringsByLength(List<String> strings) {
        // 여기에 코드 작성
        return strings.stream()
                .collect(Collectors.groupingBy(String::length));
    }
}
