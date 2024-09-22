package problem.medium;

import java.util.Comparator;
import java.util.List;

// 다시보기
public class Problem35 {

    /**
     * 주어진 문자열 리스트에서 가장 긴 단어를 찾습니다. 만약 리스트가 비어있으면 빈 문자열을 반환합니다.
     *
     * @param words 문자열 리스트
     * @return 리스트에서 가장 긴 단어, 리스트가 비어있으면 빈 문자열
     */
    public static String findLongestWord(List<String> words) {
        // 여기에 코드 작성
        return words.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }
}
