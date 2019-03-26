package Code.Sorting;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by developer on 10/26/17.
 *
 * BC: O(nlogn)
 * WC: O(n^2)
 */
public class QuickSort {

    public int partition(int[] A, int p, int r){
            //pivot = A[r]
            int i= p-1;
            for(int j=p; j<=r-1;j++){  //Elements until i are < pivot
                //Whenever an elmnt < pivot, we put it in correct position tracked by i
                if(A[j] < A[r]){
                    i = i + 1; //exchange A[i + 1 ] and A[j];
                    swap(A,i,j);
                }
            }
            i = i+1 ;
            swap(A,i,r);
        return i;
    }

    public void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }


    public void quicksort(int[] array){
        quicksort(array, 0, array.length-1);
    }

    public void quicksort(int[] array, int p, int r){
        if(p<r){
            int q = partition(array, p, r);
            quicksort(array,p,q-1);
            quicksort(array,q+1,r);
        }
    }

    @Test
    public void quicksortTest(){
        int[] A = {5,1,8,3,0,3,15,43,2};
        QuickSort qs = new QuickSort();
        qs.quicksort(A);
        int[] resultArray = {0,1,2,3,3,5,8,15,43};
        for(int i=0;i<=A.length-1;i++){
            System.out.print(A[i]+" ");
            assertEquals(resultArray[i],A[i]);
        }
    }

}
