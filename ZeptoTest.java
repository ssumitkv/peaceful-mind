public class ZeptoTest {
    public static void main(String[] args) {

        int[] heights1 = {2,1,5,6,2,3};
        int[] heights2 = {2,4};
        int[] heights3 = {2,4};
        System.out.println(calculateArea(heights1));
        System.out.println(calculateArea(heights2));
        System.out.println(calculateArea(heights3));
    }

    public static int calculateArea(int[] heights) {
        // Find area
        int start = 0, end = heights.length-1;
        int MAX_RACT = 0;
        while (start <= end) {

            // If last bar
            if(start == end) {
                if(MAX_RACT < heights[start]){
                    return heights[start];
                }
            }
            int CURR_RACT = Math.min(heights[start], heights[end]) * (end - start);

            if(CURR_RACT > MAX_RACT) {
                MAX_RACT= CURR_RACT;
            }
            // shift left 
            if(start < end) {
                start ++;
            }
            else {
                end--;
            }
            // shift right
        }
        return MAX_RACT;
    }


}
