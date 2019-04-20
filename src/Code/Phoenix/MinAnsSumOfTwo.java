package Code.Phoenix;

import java.util.Arrays;

public class MinAnsSumOfTwo {

    public int solution(int[] A) {
        Arrays.sort(A);
        int ans = Math.abs(A[0]) * 2;
        int p = 0, q = A.length - 1;
        while (p < q) {
            ans = Math.min(ans, Math.abs(A[p] + A[p]));
            ans = Math.min(ans, Math.abs(A[q] + A[q]));
            ans = Math.min(ans, Math.abs(A[p] + A[q]));
            if (ans == 0) return 0;
            else if (A[p] + A[q] > 0) {
                q--;
            } else p++;
            if ((A[p] > 0 && A[q] > 0) || (A[p] < 0 && A[q] < 0)) {
                break;
            }
        }
        return ans;
    }
}
