import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class BinarySearch {

    int searchWithStreamInIntegerArray(List<Integer> arr, Integer input) {
        Integer a =  arr.stream()
                .peek(num -> System.out.println("Current value: "+num))
                .filter(p -> p == input)
                .findFirst()
                .get();
        return a;
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        List<Integer> arr = Arrays.asList(1,2,3);

        System.out.println(bs.searchWithStreamInIntegerArray(arr, 3));
    }
}
