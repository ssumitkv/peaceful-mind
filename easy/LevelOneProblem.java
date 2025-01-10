package easy;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LevelOneProblem {
    public static void main(String[] args) {
    //     System.out.println ("HA HA HA HA HAA");
    //     List<Integer> results = Arrays.asList(-1, -1, -1, -1, -1, -1, -1, -1, -1, -1);
        int[] input = {1, 2,23};
    //     System.out.println("Fibonacci Of Input:  "+findFibonacci(9, results));
    //     System.out.println("Fibonacci of Input:  "+findFibonacci(9));

    //     System.out.println("Factorial of Input:  "+calculateFactorial(5));
    //     int[] reversedArray = reverseArray(input, 0, input.length-1);

    //     System.out.println("Reverse:  "+Arrays.toString(reversedArray));
    //     System.out.println("Subsets:  "+subsets(input));
        System.out.println("Powerset Subsets:  "+ powerSet(input) );
        // powerSet(input);

        

        // System.out.println("Is palindrome: "+isPalindrome(input, 0, input.length-1));
    }

    private static Boolean isPalindrome(int[] input, int start, int end) {
        if(start >= end) {
            return true;
        }
        if(input[start] != input[end]) {
            return false;
        }
        


        return isPalindrome(input, start+1, end-1);
    }

    public static int findFibonacci(int n, List<Integer> results) {
        if(results.get(n) != -1) {
            return results.get(n);
        }
        if(n <= 1) {
            return n;
        }
        Integer f = findFibonacci(n-1, results) + findFibonacci(n-2, results);
        results.set(n, f);
        return results.get(n);
    }

    public static int findFibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        return findFibonacci(n-1) + findFibonacci(n-2);
    }

    public static int calculateFactorial(int n) {
        if(n == 0) {
            return 1;
        }
        return n * calculateFactorial(n-1);
    }

    static void  swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int[] reverseArray(int arr[], int start, int end)  {
        if(start >= end) {
            return arr;
        }
        swap(arr, start, end);
        return reverseArray(arr, start+1, end-1);

    }

//    Power set.
//    Given a set of distinct integers, nums, return all possible subsets (the power set).
//    Note: The solution set must not contain duplicate subsets.
//    Example:
//    Input: nums = [1,2,3]
//    Output: [ [3], [1], [2], [1,2,3], [1,3], [2,3], [1,2], [] ]
    public static List<List<Integer>> subsets(int[] nums) { // 1, 2, 3
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        for(int num : nums) {
            int size = result.size();
            for(int i = 0; i < size; i++) {
                List<Integer> subset = new ArrayList<>(result.get(i));
                subset.add(num);
                result.add(subset);
            }
        }
        return result;
    }


    
    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> results = new ArrayList<>();
     
        int n = nums.length;
        int total = 1 << n;
        for(int i = 0; i < total; i++) {
            List<Integer> temp = new ArrayList<>();
            for(int j =0; j < n; j++) {
                if((i & (1<<j)) != 0) {
                    System.out.print(nums[j]);
                    temp.add(nums[j]);
                }
            }
            System.out.println();
            results.add(temp);

        }
        return results;

    }

}