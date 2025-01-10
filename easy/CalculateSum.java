package easy;
import java.util.ArrayList;
import java.util.Arrays;

public class CalculateSum {

    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int tempSum= 0;
        int start=1; int end = 1;
        for( int i =0; i < n; i++) {
            tempSum += arr[i];
            end = i;
//            System.out.println("Temp Sum: "+tempSum+"    Start: "+start+ "   End: "+end);

            while(tempSum > s && start < end) {
                System.out.println("Temp Sum: "+tempSum+"    Start: "+start+ "   End: "+end);
                tempSum -= arr[start-1];
                start++;
            }
            if(tempSum == s) {
                return new ArrayList<Integer>( Arrays.asList(new Integer[]{start, end}));
            }
        }
        return new ArrayList<Integer>( Arrays.asList(new Integer[]{-1}) );
    }
}