package hard;

public class TrappingWater {
    
// Approch 1: bruteforce - for each building calculate capacity by finding the min(leftmax, rightMax)



    public static void main(String[] args) {
        int[] arr1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        int[] arr2 = {4,2,0,3,2,5};
        System.out.println("Current capacity: "+calculateCapacityBruteForce(arr1));
        System.out.println("Current capacity: "+calculateCapacityUsingPrefixPostfixArrya(arr1));
        System.out.println("Current capacity: "+calculateCapacityBruteForce(arr2));
        System.out.println("Current capacity: "+calculateCapacityUsingPrefixPostfixArrya(arr2));
    }

    public static int calculateCapacityUsingPrefixPostfixArrya(int[] heights) {
        int[] leftPrefixArray = new int[heights.length];
        int[] rightPrefixArray = new int[heights.length];
        leftPrefixArray[0] = heights[0];
        rightPrefixArray[heights.length-1] = heights[heights.length-1];
        
        for(int i = 0; i < heights.length-1 ; i++) {
            if(leftPrefixArray[i] < heights[i+1]) {
                leftPrefixArray[i+1] = heights[i+1];
            }else{
                leftPrefixArray[i+1] = leftPrefixArray[i];
            }
        }

        for(int i = heights.length -1; i > 0 ; i--) {
            if(rightPrefixArray[i] < heights[i-1]) {
                rightPrefixArray[i-1] = heights[i-1];
            }else{
                rightPrefixArray[i-1] = rightPrefixArray[i];
            }
        }
        // System.out.println("Right: "+printArr(rightPrefixArray));
        // System.out.println("left: "+printArr(leftPrefixArray));
        int capacity = 0;

        for (int i = 0; i < rightPrefixArray.length; i++) {
            capacity += Math.min(rightPrefixArray[i], leftPrefixArray[i]) - heights[i];
        }
    
        return capacity;
    }
    
    
        private static String printArr(int[] leftPrefixArray) {
            
            StringBuilder str = new StringBuilder();
            for (int i : leftPrefixArray) {
                str.append(i+" ");
            }
            return str.toString();
        }
    
        public static int calculateCapacityBruteForce(int[] heights) {
        int leftMax = 0;
        int rightMax = 0, capacity = 0;

        for(int i = 1; i < heights.length; i++) {
            leftMax = heights[i];
            rightMax = heights[i];
            // check left
            for(int j = i-1 ; j >= 0 ; j--) {
                if(leftMax < heights[j]) {
                    leftMax = heights[j];
                }
            }

            // check right
            for(int j = i+1 ; j < heights.length ; j++) {
                if(rightMax < heights[j]) {
                    rightMax = heights[j];
                }   
            }

            int currentCapacity = Math.min(leftMax, rightMax) - heights[i];
            capacity += currentCapacity;

        }

        
        return capacity;
    }

}
