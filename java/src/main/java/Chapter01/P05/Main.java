package Chapter01.P05;


import org.apache.commons.lang3.tuple.Pair;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String value = "ajiefjksdlasdjfka"; // 5 12

        Pair pair = countVowelAndCosonants(value);
        System.out.println(pair.getLeft() + " " + pair.getRight());

        pair = countVowelAndCosonants_lamda(value);
        System.out.println(pair.getLeft() + " " + pair.getRight());

        pair = countVowelAndCosonants_lamda2(value);
        System.out.println(pair.getLeft() + " " + pair.getRight());
    }

    private static final Set<Character> allVowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public static Pair<Integer, Integer> countVowelAndCosonants(String str) {
        str = str.toLowerCase();
        int vowels = 0;
        int consonants = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (allVowels.contains(ch)) {
                vowels++;
            } else if ((ch >= 'a') && (ch <= 'z')) {
                consonants++;
            }

        }
        return Pair.of(vowels, consonants);
    }

    public static Pair<Long, Long> countVowelAndCosonants_lamda(String str) {
        str = str.toLowerCase();

        long vowels = str.chars()
                .filter(c -> allVowels.contains((char) c))
                .count();

        long consonants = str.chars()
                .filter(c -> !allVowels.contains((char) c))
                .filter(ch -> (ch >= 'a') && (ch <= 'z'))
                .count();

        return Pair.of(vowels, consonants);
    }

    public static Pair<Long, Long> countVowelAndCosonants_lamda2(String str) {
        Map<Boolean, Long> result = str.chars()
                .mapToObj(c -> (char) c)
                .filter(ch -> (ch >= 'a') && (ch <= 'z'))
                .collect(Collectors.partitioningBy(c -> allVowels.contains(c), Collectors.counting()));
        return Pair.of(result.get(true), result.get(false));
    }

}
