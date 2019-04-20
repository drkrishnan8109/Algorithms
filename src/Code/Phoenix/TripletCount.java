package Code.Phoenix;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class TripletCount {

    /**
     * def solution(A):
     *     A.sort()
     *     print A
     *     triangle_cnt = 0
     *
     *     for P_idx in xrange(0, len(A)-2):
     *         Q_idx = P_idx + 1
     *         R_idx = P_idx + 2
     *         while (R_idx < len(A)):
     *             if A[P_idx] + A[Q_idx] > A[R_idx]:
     *                 triangle_cnt += R_idx - Q_idx
     *                 R_idx += 1
     *             elif Q_idx < R_idx -1:
     *                     Q_idx += 1
     *             else:
     *                 R_idx += 1
     *                 Q_idx += 1
     *
     *     return triangle_cnt
     *
     *     */

        public int findTripletCount(int[] A) {
            // write your code in Java SE 8
            Arrays.sort(A);
            int count=0;

            int left,right;

            // A[0] = 10    A[1] = 2    A[2] = 5
            //  A[3] = 1     A[4] = 8    A[5] = 12

            //(0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).
            //(10,5,8), (10,5,12), (10,8,12), (5,8,12)

            for(int i=0;i<A.length-2;i++) {
                left = i+1; right = i+2;

                while(right<A.length ) {
                    if(A[i]+A[left] > A[right]) {
                        right++;
                        count += (right - left);
                    }
                    else if(left < right-1){
                       left++;
                    }
                    else {
                        left++;
                        right++;
                    }
                }
            }

            return count;
        }

        @Test
    public void test() {
            // A[0] = 10    A[1] = 2    A[2] = 5
            //  A[3] = 1     A[4] = 8    A[5] = 12

            //(0, 2, 4), (0, 2, 5), (0, 4, 5), and (2, 4, 5).
            //(10,5,8), (10,5,12), (10,8,12), (5,8,12)
            int[] A = new int[] {10,2,5,1,8,12};
            TripletCount t = new TripletCount();
            int k =t.findTripletCount(A);
            assertEquals(4,k);
        }
}
