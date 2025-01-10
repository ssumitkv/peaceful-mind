package test.others;

public class PermutationProblems {


    public static void nextPermutation(int[] nums) {
        // find next bigger number
        // step 1: find the break point: where curr index < current+1 while traversing from back
        // step 2: replace: current with next bigger element in right side
        // step 3: sort the elements after current

        int breakPoint = -1;

        for (int i = nums.length-2 ; i >=0 ; i--) {
            if(nums[i] < nums[i+1]) {
                breakPoint = i;
                break;
            }
        }
        if(breakPoint == -1) {
            nums = reverseArr(nums, 0, nums.length-1);
            System.err.println(nums[0]+"  "+nums[1]+"  "+ nums[2]);
            return;
        }
        for(int i = nums.length-1; i > breakPoint; i --) {
            if(nums[i] > nums[breakPoint]) {
                nums = swap(nums, breakPoint, i);
                break;
            }
        }

        reverseArr(nums, breakPoint+1, nums.length-1);
        System.err.println(nums[0]+"  "+nums[1]+"  "+ nums[2]);
    }

    public static int[] reverseArr(int[] arr, int start, int end) {
        while(start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
        return arr;
    }

    public static int[] swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;

        return arr;
    }
    
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        nextPermutation(nums);
    }
}
