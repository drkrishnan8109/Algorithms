package Code.Phoenix;

import java.util.HashSet;
import java.util.Set;

/**
 * A pair of integers (P, Q), such that 0 ≤ P ≤ Q < N, is called a slice of array A. The slice consists of the elements A[P], A[P + 1], ..., A[Q]. A distinct slice is a slice consisting of only unique numbers. That is, no individual number occurs more than once in the slice.
 *
 * For example, consider integer M = 6 and array A such that:
 *
 *     A[0] = 3
 *     A[1] = 4
 *     A[2] = 5
 *     A[3] = 5
 *     A[4] = 2
 * There are exactly nine distinct slices: (0, 0), (0, 1), (0, 2), (1, 1), (1, 2), (2, 2), (3, 3), (3, 4) and (4, 4).
 *
 * The goal is to calculate the number of distinct slices.
 *
 * */
public class DistinctSlices {

    public int distinctSizes(int[] A) {
        int low=0,high=0;
        Set<Integer> hs = new HashSet<>();

        int count=0;
        // 3 4 5 5 2
        while(low<=high) {
            if(high < A.length && !hs.contains(A[high])) {
                    hs.add(A[high]);
                    count++;
                    high++;
            } else {
                low++;
               //count++;
            }
            }
        return  count;
    }
}
