package Chapter01.P02;

import javax.xml.stream.events.Characters;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {


    /**
     * 배열을 생성하여 문자열에서 한 번만 나오는 문자들의 인덱스를 저장ㅎ나다.
     * 이후 반복되지 않는 문자들을 포함하는 이 배열에서 가장 작은 인덱스를 반환한다.
     *
     * @param str
     * @return
     */
    public static char firstNonRepeatedCharacter(String str) {
        int[] flag = new int[Character.MAX_VALUE];

        for (int i = 0; i < flag.length; i++) {
            flag[i] = -1;

        }

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            flag[ch] = flag[ch] == -1 ? i : -2;
        }

        int position = Integer.MAX_VALUE;
        for (int i = 0; i < flag.length; i++) {
            if (flag[i] >= 0) {
                position = Math.min(position, flag[i]);
            }
        }

        return position == Integer.MAX_VALUE ? Character.MAX_VALUE : str.charAt(position);
    }


    /**
     * LinkedHashMap활용
     * LinkedHashMap은 삽입 순서를 유지하는 맵으로 이 해법에 사용 하면 아주 편리하다
     * 문자를 키로 빈도를 값으로 해서 만들어진다.
     * @param str
     * @return
     */
    public static char firstNonRepeatedCharacter_LinkedHashMap(String str) {
        Map<Character, Integer> chars = new LinkedHashMap<>();

        for (char ch : str.toCharArray()) {
            chars.compute(ch, (k, v) -> (v == null) ? 1 : ++v);
        }

        for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return Character.MIN_VALUE;
    }

    public static String firstNonRepeatedCharacter_lamda(String str){
        Map<Integer, Long> chs = str.codePoints().collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        int cp = chs.entrySet().stream()
                .filter(e-> e.getValue()==1L)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(Integer.valueOf(Character.MIN_VALUE));
        return String.valueOf(Character.toChars(cp));

    }

    public static void main(String[] args) {


        String value = "zasdfjklsadfjklsadaap123123";
        System.out.println(firstNonRepeatedCharacter(value));
        System.out.println("firstNonRepeatedCharacter_LinkedHashMap: " + firstNonRepeatedCharacter_LinkedHashMap(value));


    }
}
