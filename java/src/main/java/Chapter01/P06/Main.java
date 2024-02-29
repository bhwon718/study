package Chapter01.P06;

import java.util.function.DoubleToIntFunction;

public class Main {
    public static void main(String[] args) {
        String value = "asdjkljsdlkgaj";
        System.out.println(countOccurrencesOfACertainCharacter(value, 'a'));
        System.out.println(countOccurrencesOfACertainCharacter_2(value, "a"));
        System.out.println(countOccurrencesOfACertainCharacter_3(value, 'a'));
        System.out.println(countOccurrencesOfACertainCharacter_lamda(value, 'a'));
    }


    /**
     * 주어진 문지를 지워서 줄어든 문자수를 센다
     *
     * @param str
     * @param ch
     * @return
     */
    public static int countOccurrencesOfACertainCharacter(String str, char ch) {
        return str.length() - str.replace(String.valueOf(ch), "").length();
    }


    // 유니코드 대리 쌍까지 처리
    public static int countOccurrencesOfACertainCharacter_2(String str, String ch) {
        //주어진 문자열에 유니코드 문자가 둘 이상이면
        if (ch.codePointCount(0, ch.length()) > 1) {
            return -1;
        }
        int result = str.length() - str.replace(ch, "").length();

        // ch.length()가 2를 반환하면 유니코드 대리 쌍이라는 뜻이다.
        return ch.length() == 2 ? result / 2 : result;
    }


    public static int countOccurrencesOfACertainCharacter_3(String str, char ch) {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ch) {
                count++;
            }
        }

        return count;
    }

    public static long countOccurrencesOfACertainCharacter_lamda(String str, char ch) {
        return str.chars().filter(c-> c==ch).count();
    }
}
