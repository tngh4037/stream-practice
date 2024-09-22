package problem.medium;

import java.util.List;
import java.util.Locale;

public class Problem49 {

    /**
     * 주어진 문자열 리스트에서 각 문자열의 첫 글자를 대문자로 변환하고,
     * 나머지 글자는 소문자로 변환한 새로운 리스트를 반환합니다.
     *
     * @param strings 문자열 리스트
     * @return 변환된 문자열 리스트
     */
    public static List<String> capitalizeFirstLetter(List<String> strings) {
        // 여기에 코드 작성
        return strings.stream()
                .map(str -> str.substring(0, 1).toUpperCase(Locale.ROOT) + str.substring(1).toLowerCase())
                .toList();
    }
}
