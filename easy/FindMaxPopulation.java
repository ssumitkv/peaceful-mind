package easy;

public class FindMaxPopulation {


    static int findMaxPopulation(int[][] birthDeathlog) {
        int[] years = new int[101];
        for (int i=0; i < birthDeathlog.length; i++ ) {
            int[] bD = birthDeathlog[i];
            
            int birth = bD[0]-1950;
            int death = bD[1]-1950;

            years[birth] = years[birth]+1;
            years[death] = years[death]-1;
        }
        int result = 0;
        int maxPopulation = 0;
        int currPopulation = 0;
        for (int i =0; i < 101; i++) {
            maxPopulation+=years[i];
            if(maxPopulation > currPopulation) {
                maxPopulation = currPopulation;
                result = 1950+i;
            }
            
        }
        return result;
    }
        
    public static void main(String[] args) {
        
        int[][] input1 = {{1980, 1990}, {1975, 1985}, {1985, 1995}, {1990, 2000}, {1999, 2020}, {1994, 2032}};  // 1994
        int[][] input2 = {{1970, 1990}, {1980, 2009}, {1960, 1970}, {1959, 1982}};
        int[][] input3 = {{2000, 2010}, {2005, 2015}, {2010, 2020}, {2015, 2025}};

        System.err.println("Max population on: "+findMaxPopulation(input1));
        System.err.println("Max population on: "+findMaxPopulation(input2));
        System.err.println("Max population on: "+findMaxPopulation(input3));
    }
    
}
