package Code.Phoenix;

import Code.Sorting.MergeSort;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmallestPsitiveNumber {

        public int solution(int[] A) {
            if(A==null || A.length==0 || ((A.length==1) && A[0]<=1))
                return -1;

            if(A.length==1) {
                return A[0]-1;
            }

            MS(A,0,A.length-1);
            //1 1 2 3 4 6

            int x=A[0];
            for(int i=1;i<A.length;i++) {
                if(A[i-1] == A[i])
                    continue;
                if(A[i-1]+1 !=A[i]) {
                    return A[i-1]+1;
                }
            }
            return A[A.length-1];
        }

        public void MS(int[] A, int start, int end){
            if(start<end) {
                int q = (start + end) / 2;
                MS(A, start, q); // 0,9.. 0,4..0,2..0,1..0,0->5
                MS(A, q + 1, end); // 0,0->5
                mergeArrays(A, start, q , end);//5
            }
        }

        /** Merge takes O(n) */
        public void mergeArrays(int[] A, int p, int q, int r){
            int n,m;
            n = q-p+1; m = r - (q+1)+1; //n=1,m=1
            int[] LeftArray = new int[n];
            int[] RgtArray = new int[m];

            //Using infinite value to copy full array properly is not working
            //LeftArray[n] = Integer.MAX_VALUE;
            //RgtArray[m]  = Integer.MAX_VALUE;

            for (int i=0;i<n;i++)
                LeftArray[i]=A[p+i];

            for (int i=0;i<m;i++)
                RgtArray[i]=A[q+1+i];

            int i =0, j=0, k=p;
            while(i<n && j<m){
                if(LeftArray[i] <= RgtArray[j]){
                    A[k] = LeftArray[i];
                    i++;
                }else{
                    A[k] = RgtArray[j];
                    j++;
                }
                k++;
            }

            //Since we exit from the while loop when one of the conditions is wrong (i<n && j<m),
            //we might still have to copy remaining based on other condition which stayed true.

            //* Copy remaining elements of L[] if any *//*
            while (i < n)
            {
                A[k] = LeftArray[i];
                i++;
                k++;
            }

            //* Copy remaining elements of R[] if any *//*
            while (j < m)
            {
                A[k] = RgtArray[j];
                j++;
                k++;
            }
        }

    @Test
    public void mergeTest(){
       // int[] A = {5,1,8,3,0,53,15,43};
        int[] A = {1, 3, 6, 4, 1, 2};
        solution(A);
        MS(A,0,A.length-1);
        int[] resultArray = {1,1,2,3,4,6};

        for(int i=0;i<=A.length-1;i++){
            System.out.print(A[i]+" ");
            assertEquals(resultArray[i],A[i]);
        }
    }
}
