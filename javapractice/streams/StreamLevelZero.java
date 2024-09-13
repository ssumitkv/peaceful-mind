package javapractice.streams;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamLevelZero {
    
    List<Integer> filterAndCollectEvenNumbers(List<Integer> numbers) {
        List<Integer> result = new ArrayList<>();
        
        result = numbers.stream()
                        .filter(n -> n % 2 == 0)
                        .collect(Collectors.toList());

        return result;
    }

    List<Integer> countNumberOfCharactersInASentance(String text) {
        List<Integer> counts = new ArrayList<>();
        List<String> textList = Arrays.asList( text.split(" "));
        counts.addAll(textList.stream()
                .map(String::length)
                .collect(Collectors.toList()));
         return counts;
    }

    Map<String, Integer> countNumberOfCharactersInASentanceWithValue(String text) {
        List<String> textList = Arrays.asList( text.split(" "));
        Map<String, Integer> counts = textList.stream()
                .collect(Collectors.toMap(word -> word, String::length));
         return counts;
    }

    List<String> mergeTwoDimantionArray(List<List<String>> twoDList) {
        return twoDList.stream()
                        .flatMap(Collection::stream)
                        .collect(Collectors.toList());
    }

    Map<String, Long> findCountOfCharacters(String input) {
        Map<String, Long> result = 
                Arrays  .stream(input.split(""))
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return result;
    }

    Map<Character, Long> countNumberOfCharactersOfFristCharacterFromListOfWords(List<String> words) {
        Map<Character, Long> result = new HashMap<>();
        result = words.stream()
            .collect(Collectors.groupingBy(word -> word.charAt(0), Collectors.counting()));
        return result;
    }

    Map<String, Integer> findCountOfCharactersWithoutUsingGroupBy(String input) {
        Map<String, Integer> result = new HashMap<>();
        
        Arrays
            .stream(input.split(""))
            .forEach(c -> result.put(c, result.getOrDefault(c, 0)+1)  );


        return result;
    }

/*
Doc/Questions: 
https://chatgpt.com/share/2738c199-b431-485a-9904-389a34ff1f47

Intermediate:
    filter()
    map()
    flatMap()
    distinct()
    sorted()
    peek()

Terminal:
    forEach()
    collect()
    count()
    reduce()
    forEachOrdered()

 */
    public static void main(String[] args) {

        List<Integer> input = Arrays.asList(1,2, 2,3,3,4,5);
        StreamLevelZero streamLevelZero = new StreamLevelZero();
        System.out.println("Search Even number: "+streamLevelZero.filterAndCollectEvenNumbers(input));
        System.out.println("Count number of char of each characters : "+streamLevelZero.countNumberOfCharactersInASentance("Hello this is sumit ka problem."));
        System.out.println("Count number of char of each characters : "+streamLevelZero.countNumberOfCharactersInASentanceWithValue("Hello this is sumit ka problem."));


        List<List<String>> strings = new ArrayList<>();
        strings.add(Arrays.asList("Hel", "oo"));
        strings.add(Arrays.asList("Cel", "oo"));
        strings.add(Arrays.asList("Kel", "oo"));

        System.out.println("Merged 2D array:   "+streamLevelZero.mergeTwoDimantionArray(strings));
        System.out.println("Print number of characters"+streamLevelZero.findCountOfCharacters("Hello  dododo."));
        System.out.println("Print number of characters"+streamLevelZero.findCountOfCharactersWithoutUsingGroupBy("Hello  dododo."));
        System.out.println("Print number of first characters"+streamLevelZero.countNumberOfCharactersOfFristCharacterFromListOfWords(Arrays.asList("Hello", "he", "tin", "pin")));


    }

}
