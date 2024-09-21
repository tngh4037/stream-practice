package problem.easy;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

// 다시보기
public class Problem28 {

    /**
     * 주어진 문자열 리스트에서 가장 긴 문자열을 찾습니다.
     *
     * @param strings 문자열 리스트
     * @return 가장 긴 문자열 (리스트가 비어있으면 Optional.empty())
     */
    public static Optional<String> findLongestString(List<String> strings) {
        // 여기에 코드 작성
        return strings.stream().max(Comparator.comparingInt(str -> str.length()));

        //return strings.stream()
        //        .reduce((oldStr, newStr) -> oldStr.length() > newStr.length() ? oldStr : newStr);

        //return strings.stream()
        //        .sorted(Comparator.comparing(str -> str.length(), Comparator.reverseOrder()))
        //        .findFirst();
    }
}
