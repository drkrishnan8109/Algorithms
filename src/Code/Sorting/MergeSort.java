package Code.Sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by Dhanya on 10/7/17.
 * Guarantees O(nlogn)
 * Uses extra space of O(n) for sublists
 *
 * Array [p...r]
 * Create sub arrays [p...q] and [q+1...r]
 * While merging:
 * So n1= q-p+1 and n2=r-(q+1)+1= r-q
 *
 * => n1 = q - p +1
 * => n2 = r - q
 *
 * 0 to <n1 Store L[i] =  A[p+i]    ---> bcs L begins from p
 * 0 to <n2 Store R[j] =  A[q+1+j]  ---> bcs R begins from q+1
 *
 * Finally, also copy the remaining elements of both L and R to destination
 */
public class MergeSort {

    public void mergesort(int[] A){
         mergesort(A, 0, A.length-1);
    }

    public void mergesort(int[] A, int start, int end){
        if(start<end) {
            int q = (start + end) / 2;
            mergesort(A, start, q); // 0,9.. 0,4..0,2..0,1..0,0->5
            mergesort(A, q + 1, end); // 0,0->5
            merge(A, start, q , end);//5
        }
    }

    /** Merge takes O(n) */
    public void merge(int[] A, int p, int q, int r){
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
        int[] A = {5,1,8,3,0,53,15,43};
        MergeSort mrgSort = new MergeSort();
        mrgSort.mergesort(A);
        int[] resultArray = {0,1,3,5,8,15,43,53};
        for(int i=0;i<=A.length-1;i++){
            System.out.print(A[i]+" ");
            assertEquals(resultArray[i],A[i]);
        }
    }

    @Test
    public void mergeTest2(){
        int[] A = {55,12,8,53,873,1,53,135,43};
        MergeSort mrgSort = new MergeSort();
        mrgSort.mergesort(A);
        int[] resultArray = {1,8,12,43,53,53,55,135,873};
        for(int i=0;i<=A.length-1;i++){
            System.out.print(A[i]+" ");
            assertEquals(resultArray[i],A[i]);
        }
    }
}
