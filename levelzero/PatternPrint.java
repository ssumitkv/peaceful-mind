package levelzero;

import java.util.stream.IntStream;

public class PatternPrint {

/*
Pattern 1:
        * * * * * 
        * * * * * 
        * * * * * 
        * * * * * 
        * * * * * 
 */
    void squareStarPrint(int length, int height) {

        IntStream.range(0, height).forEach( pheight -> {
            IntStream.range(0, length).forEach( index -> {
                System.out.print("* ");
            });
            System.out.println();
        });
    }


/*
Pattern 2:
        *
        **
        ***
        ****
 */
    void tranglePrint(int height) {
        for(int i=0; i < height; i++) {
            for(int j=0; j <= i; j++) {
                System.err.print("*");
            }
            System.out.println();
        }
    }

/*
    Pattern 3:
    1
    12
    123
    1234
 */
    void numberInTrangle(int height) {
        for(int i=1; i<= height; i++) {
            for(int j=1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

/*
    Pattern 4:
        1
        22
        333
        4444
 */
void numberInTrangleTypeSecond(int height) {
    for(int i=1; i<= height; i++) {
        for(int j=1; j <= i; j++) {
            System.out.print(i);
        }
        System.out.println();
    }
}

/*
    Pattrn: 5:
    ****
    ***
    **
    *
 */
    void invertedStarTrangle(int height) { 
        for(int i = height; i > 0; i--) {
            for(int j = 0; j < i ; j++) {
                System.out.print("*");
            }
            System.out.println();
        }       
    }

    /*
     Pattern 6: 
        1234
        123
        12
        1
     */

    void invertedNumberTrangle(int height) {
        for(int i = height; i > 0; i--) {
            for(int j = 1; j <= i ; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

/*
    Pattern 7
    * 
   * * 
  * * * 
 * * * * 
* * * * * 
 */
    void centeredTrangle(int height) {

        for(int i = 0; i <= height; i++) {
            int space = height-i;
            for(int k=0; k < space; k++) {
                System.err.print(" ");
            }
            for(int j = 0; j < i ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

/*
 Patern 8:
 
* * * * * 
 * * * * 
  * * * 
   * * 
    * 
 
 */
    public void reverseTranglePatter(int height) {
        for (int i = height; i > 0; i--) {
            int space = height-i;
            for(int k = 0; k < space; k++ ) {
                System.err.print(" ");
            }
            for(int j=0; j < i; j ++) {
                System.err.print("* ");
            }
            System.out.println();
        }
    }

/* 
Patern 8:

*/
    public void bothEndedPattern(int height){
        
    }

    public static void main(String[] args) {
        PatternPrint patternPrint = new PatternPrint();
        // patternPrint.squareStarPrint(5, 5);
        // patternPrint.tranglePrint(4);
        // patternPrint.numberInTrangle(4);
        // patternPrint.numberInTrangleTypeSecond(4);
        // patternPrint.invertedStarTrangle(4);
        // patternPrint.invertedNumberTrangle(4);
        // patternPrint.centeredTrangle(5);
        patternPrint.reverseTranglePatter(5);
    }
    
}
