package problem.hard;

import java.util.Comparator;
import java.util.List;

// 다시보기
public class Problem67 {

    /**
     * 주어진 문자열 리스트에서 모든 문자열이 공유하는 가장 긴 접두사를 찾습니다.
     * 공통 접두사가 없는 경우 빈 문자열을 반환합니다.
     *
     * @param strings 문자열 리스트
     * @return 가장 긴 공통 접두사, 없으면 빈 문자열
     */
    public static String findLongestCommonPrefix(List<String> strings) {
        // 여기에 코드 작성
        String minStr = strings.stream().min(Comparator.comparing(String::length)).orElse("");
        if (minStr.isEmpty()) {
            return "";
        }

        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < minStr.length(); i++) {
            final int index = i;
            long count = strings.stream()
                    .map(s -> s.charAt(index))
                    .distinct()
                    .count();

            if (count == 1) {
                prefix.append(minStr.charAt(index));
            } else {
                break;
            }
        }

        return prefix.toString();
    }
}
