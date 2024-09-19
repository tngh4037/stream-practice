package problem.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Problem14 {

    /**
     * Map에서 길이가 3 이상인 키만 필터링하여 새 Map을 생성합니다.
     *
     * @param map 원본 Map
     * @return 길이가 3 이상인 키를 포함하는 새 Map
     */
    public static Map<String, String> filterKeys(Map<String, String> map) {
        // 여기에 코드 작성
        return map.entrySet().stream()
                .filter(v -> v.getKey().length() >= 3)
                .collect(Collectors.toMap(v -> v.getKey(), v -> v.getValue()));
    }
}
