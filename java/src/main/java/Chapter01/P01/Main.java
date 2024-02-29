package Chapter01.P01;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;


/**
 * 문자 개수 세기
 */
public class Main {

    //문자를 순회하여 처리
    public static Map<Character, Integer> countDuplicateChar_mapCompute(String input) {
        Map<Character, Integer> output = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            output.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }
        return output;
    }

    //문자를 순회하여 유니코드 대리쌍 처리
    public static Map<String, Integer> countDuplicateChar_mapCompute_unicode(String input) {
        Map<String, Integer> output = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            String ch = String.valueOf(Character.toChars(input.codePointAt(i)));
            if (i < input.length() - 1 && input.codePointCount(i, i + 2) == 1) {
                i++;
            }
            output.compute(ch, (k, v) -> v == null ? 1 : ++v);
        }
        return output;
    }

    // 함수형 스타일로 처리
    public static Map<Character, Long> countDuplicateChar_stream(String input) {
        return input.chars()
                .mapToObj(c -> (char) c)  // Int Stream을 사람이 읽을수 있는 문자로 변환
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
    }

    // 함수형 스타일로 유니코드 대리쌍 처리
    public static Map<String, Long> countDuplicateChar_stream_unicode(String input) {
            return input.codePoints()
                    .mapToObj(c -> String.valueOf(Character.toChars(c)))  // Int Stream을 사람이 읽을수 있는 문자로 변환
                    .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        }


    // Map compute를 사용


    public static void main(String[] args) {
        String text = "aaaqqqqwwwreweer";
        System.out.println("countDuplicateChar_mapCompute : " + countDuplicateChar_mapCompute(text));
        System.out.println("countDuplicateChar_stream : " + countDuplicateChar_stream(text));

        String unicode_text = "❤️❤️❤️❤️❤️❤️❤️❤️💕💕💕";
        System.out.println("countDuplicateChar_stream : " + countDuplicateChar_stream(unicode_text));
        System.out.println("countDuplicateChar_mapCompute : " + countDuplicateChar_mapCompute_unicode(unicode_text));
        System.out.println("countDuplicateChar_stream : " + countDuplicateChar_stream_unicode(unicode_text));

    }

}
