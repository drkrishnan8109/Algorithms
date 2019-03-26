package Code.NP;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dhanya on 10/14/17.
 * Greedy solution by constructing Value matrix
 */
public class Knapsack {
    /**At 0th col, the knapsack has weight 0, so nothing can be filled - hence all zeros
     * At 0th row, there is no item, hence nothing can be filled -- all zeros
     * {
     * These 0 coln is needed, bcs we carry forward previous weights, and it becomes useful
     * - else we face index out of bounds  when we want to carry forward
     * previous wgt for item at index 0 if input wt array
     * }
     * At v[1,1], can we fill first item if weight of knapsack is w?
     * If yes, insert value of the first item because it is a value matrix
     *
     * TC = O(NW) where N is number of elements, W is expected maximum weight
     */

        // val[i] and wt[i] represent value and weight of i-th item respectively
        public static int knapsack(int val[], int wt[], int W) {

            //Get the total number of items.
            //Could be wt.length or val.length. Doesn't matter
            int N = wt.length;

            //Create a matrix.
            //Items are in rows and weight at in columns +1 on each side
            int[][] V = new int[N + 1][W + 1];


            //What if the knapsack's capacity is 0
            // Then set all columns at row 0 to be 0
            for (int col = 0; col <= W; col++) {
                V[0][col] = 0;
            }
            //What if there are no items at home.
            //Fill the first row with 0
            for (int row = 0; row <= N; row++) {
                V[row][0] = 0;
            }

            for (int item=1;item<=N;item++){

                //Let's fill the values row by row
                for (int weight=1;weight<=W;weight++){

                    //Is the current items weight <= running weight
                    //here curr element is at index item-1 of array since V matrix is build with one indx more
                    // wt[item-1] : Bcs this is the input wt array, it has 1st item at index 0
                    if(wt[item-1] > weight) {
                        //If the current item's weight is more than the
                        //running weight, just carry forward the value
                        //without the current item
                        V[item][weight]= V[item-1][weight];
                    }
                    else{
                    //Given a weight, check if the value of the
                    //current item + value of the item that we could afford
                    //with the remaining weight is greater than the value
                    //without the current item itself
                        V[item][weight]= Math.max (
                                V[item-1][weight],
                                val[item-1] + V[item-1][weight-wt[item-1]]
                                );
                    }
                }
            }

            //Printing the matrix
            for (int[] rows : V) {
                for (int col : rows) {
                    System.out.format("%5d", col);
                }
                System.out.println();
            }

            return V[N][W];

        }

    @Test
    public void knapsackTest() {
        int val[] = {10, 40, 30, 50};
        int wt[] = {5, 4, 6, 3};
        int W = 10;
        Knapsack k = new Knapsack();
        k.knapsack(val, wt,W);
    }


}
