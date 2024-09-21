package problem.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

// 다시보기
public class Problem19 {

    /**
     * 스트림을 사용하여 문자열 배열에서 TreeMap을 생성합니다.
     * 배열의 각 요소를 key로 하고, 해당 요소의 길이를 value로 하는 TreeMap을 반환합니다.
     *
     * @param strings 문자열 배열
     * @return 생성된 TreeMap
     */
    public static Map<String, Integer> createTreeMapFromStream(String[] strings) {
        // 여기에 코드 작성
        return Arrays.stream(strings)
                .collect(Collectors.toMap(
                        v -> v, 
                        v -> v.length(), 
                        (existing, replacement) -> existing, // 충돌 해결 함수
                        TreeMap::new)); // TreeMap 을 사용하도록 지정
    }
}
