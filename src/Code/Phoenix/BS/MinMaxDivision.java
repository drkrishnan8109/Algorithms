package Code.Phoenix.BS;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Write a function:  class Solution { public int solution(int K, int M, int[] A); }
 * that, given integers K, M and a non-empty array A consisting of N integers, returns the minimal large sum.
 *
 * For example, you are given integers K = 3, M = 5 and array A such that:
 *
 *   A[0] = 2
 *   A[1] = 1
 *   A[2] = 5
 *   A[3] = 1
 *   A[4] = 2
 *   A[5] = 2
 *   A[6] = 2
 * The array can be divided, for example, into the following blocks:
 *
 * [2, 1, 5, 1, 2, 2, 2], [], [] with a large sum of 15;
 * [2], [1, 5, 1, 2], [2, 2] with a large sum of 9;
 * [2, 1, 5], [], [1, 2, 2, 2] with a large sum of 8;
 * [2, 1], [5, 1], [2, 2, 2] with a large sum of 6.
 * The goal is to minimize the large sum. In the above example, 6 is the minimal large sum.
 *
 * */

public class MinMaxDivision {

    //k is the number of blocks allowed
    public int minLargeSum(int[] A,int allowed_block_count) {
        int lower_bound = max(A);
        int upper_bound = sum(A);

        int mid;
        while (lower_bound<=upper_bound) {
            mid = (lower_bound+upper_bound)/2;

            if(blockIsValid(A,mid,allowed_block_count))
                upper_bound = mid -1;
            else
                lower_bound = mid +1;
        }
        return lower_bound; // looking for min value of sub block sum
    }

    public boolean blockIsValid(int[] A, int sum, int allowed_block_count) {
        int block_count =0;
        int block_sum=0;

        for(int i=0;i<A.length;i++) {

            if(block_sum + A[i] <= sum) {
                block_sum +=A[i];
            }
            else{
                block_sum = A[i];
                block_count++;
            }

            if(block_count>=allowed_block_count)
                return false;
        }
        return true;
    }

    public int max(int[] A) {
        int max = A[0];
        for (int i=1;i<A.length;i++) {
            if(max<A[i])
                max =A[i];
        }
        return max;
    }

    public int sum(int[] A) {
        int sum=0;
        for (int i=0;i<A.length;i++) {
            sum+=A[i];
        }
        return sum;
    }

    @Test
    public void test() {
        int[] A = new int[] {2,1,5,1,2,2,2};
        int minSum = (new MinMaxDivision()).minLargeSum(A,3);
        assertEquals(6,minSum);
    }
}
