package Code.Phoenix;

public class PrefixSum {

    public int[] prefixSums(int[] A) {
        int[] P = new int[A.length+1];
        for(int i=1;i<A.length;i++) {
            P[i] = P[i-1] + A[i-1];
        }
        return P;
    }

    public int countSlice(int[] P, int x, int y) {
        return P[y+1] - P[x];
    }


}
