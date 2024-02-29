package Chapter01.P04;

import org.apache.commons.lang3.StringUtils;

public class Main {

    public static void main(String[] args) {
        String value1 = "11111";
        String value2 = "1111a1";

        System.out.println(containsOnlyDigits(value1));
        System.out.println(containsOnlyDigits(value2));

        System.out.println(containsOnlyDigits_lamda(value1));
        System.out.println(containsOnlyDigits_lamda(value2));

        System.out.println(containsOnlyDigits_matches(value1));
        System.out.println(containsOnlyDigits_matches(value2));
        System.out.println(containsOnlyDigits_commonlang(value1));
        System.out.println(containsOnlyDigits_commonlang(value2));


    }


    /**
     * Character.isDigit 사용
     *
     * @param str
     * @return
     */
    public static boolean containsOnlyDigits(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) return false;
        }
        return true;
    }

    /**
     * Character.isDigit 사용
     *
     * @param str
     * @return
     */
    public static boolean containsOnlyDigits_lamda(String str) {
        return str.chars().allMatch(Character::isDigit);
    }

    /**
     * String matches()
     *
     * @param str
     * @return
     */
    public static boolean containsOnlyDigits_matches(String str) {
        return str.matches("[0-9]+");
    }


    /**
     * String matches()
     *
     * @param str
     * @return
     */
    public static boolean containsOnlyDigits_commonlang(String str) {
        return StringUtils.isNumeric(str);
    }
}
