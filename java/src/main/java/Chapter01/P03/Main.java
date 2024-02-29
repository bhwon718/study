package Chapter01.P03;

import java.util.regex.Pattern;

public class Main {

    private static final String WHITESPACE = " ";


    public static String reverseWords(String str) {
        String[] words = str.split(WHITESPACE);
        StringBuilder reversedString = new StringBuilder();

        for (String word : words) {
            StringBuilder reverseWord = new StringBuilder();

            for (int i = word.length() ; i>=0 ; i--) {
                reverseWord.append(word.charAt(i));
            }

            reversedString.append(reverseWord).append(WHITESPACE);
        }

        return reversedString.toString();
    }

    private static final Pattern PATTERN = Pattern.compile(" +");




    public static void main(String[] args) {


    }
}
