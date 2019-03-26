package Code.Sorting;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.lang.Exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * In java, since array begins from 0 -> buildMaxHeap runs from floor of n/2 to 0
 * For max heapify, when i =0, left=1 and right=2
 * Parent of i is (i-1)/2
 * and left=2i + 1 and right=2i + 2
 *
 * Logic :
 * i= floor n/2 is the biggest non-heap index
 * Find largest among 2 children of i;
 * If (largest!=i), then only:
 *      Swap with largest
 *      Maxheapify on largest
 * This largest !=i check is the Base Condition, else the recursion runs infinitely
 *
 * HeapExtract Logic:
 * Pop head of array i.e, root
 * Place last element at root & reduce size of array
 * MaxHeapify on root
 */
public class Heap {

    public void buildMaxHeap(int[] arr, int n){
        for(int i=(int)Math.floor(n/2)-1; i>=0; i--){
            maxHeapify(arr,i,n);
        }
        //return arr;
    }

    public void maxHeapify(int[] A, int i, int length){
        int left,right;
        if(i==0) {left = 1; right = 2;}
        else{
            left = 2*i + 1;
            right = 2*i + 2;
       }

        int largest = i;

        // children i.e. left&rgt should not exceed the array length
        if(left<length && A[left] > A[i]){
            largest=left;
        }
        else  largest = i;
        if(right<length && A[right] > A[largest]){
            largest=right;
        }
        if(largest != i){
             swap(A, largest, i);
             maxHeapify(A,largest,length);
        }
        //return A;
    }

    public void swap(int[] A, int i, int j){
        int temp= A[i];
        A[i]=A[j];
        A[j]=temp;
        //return A;
    }

    public void heapsort(int[] A){
        int n = A.length;
        if(A == null) return;
        if(n<1) {
            System.out.println("Heap underflow exception");
            return;
        }

        for(int i=n-1;i>=0; i--) {
            swap(A,i,0);
            maxHeapify(A,0,i);
        }
    }

    @Test
    public void maxHeap(){
        int[] arr = {1,2,64,53,2,8,742,52,31,95,41};
        buildMaxHeap(arr,11);
        for(int i=0;i<11;i++){
            System.out.print(arr[i]+",");
        }
        assertEquals(742,arr[0]);
    }

    @Test
    public void heapsortTest() {
        int[] arr = {1,2,64,53,2,8,742,52,31,95,41};
        buildMaxHeap(arr,11);
        heapsort(arr);
        System.out.print(arr[0]+",");
        for(int i=1;i<11;i++) {
            System.out.print(arr[i]+",");
            assertTrue(arr[i-1]<=arr[i]);
        }
    }

}
