package Code.Sorting;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Quick Select (based on quick sort) to find kth largest element
 * It recursively searches the array where kth element would lie after partition,
 * and ignores the other array
 * O(n) avg case and O(n^2) WC  -- We can reduce WC to O(n) using a median3 as pivot
 *
 * IMP - every elmt to left of pivot after finding correct pos of pivot, is lesser than pivot
 *
 * The same algorithm can be used to find kth smallest,
 * but instead of parameter length-k+1, pass k to qsort.
 *
 * So kthLargest -> [0 ...  arr.length-k]
 * And kthSmallest -> [0 ... k - 1]
 *-> Bcs kth largest is at position length-k and kth smallest is at position k-1
 */
public class kth {

    public int findKthLargest(int[] arr, int k){
        return qselect(arr, 0, arr.length-1, arr.length -1 - k + 1);// kth largest is at length-k position
    }
    public int findKthSmallest(int[] arr, int k){
        return qselect(arr, 0, arr.length-1, k-1);
    }

    public int qselect(int[] arr, int start, int end, int k){

        int pivot = arr[end];
        int left = start;
        int right = end; // or end-1 is exact

        while(left<right){ // or while (true), and then use break condition inside loop
            while(arr[left] < pivot && left < right){
                left++;
            }
            while(arr[right] >= pivot && left < right){
                right--;
            }
            //if(left == right) break;
            //arr = swap(arr,left,right);
            swap(arr,left,right);
           // left++;
           // right--;
        }
        swap(arr,left,end); // left is already incremented inside while loop, like i+1 in quicksort

        if(k == left ){ // means we are at the pivot element which is now at left
            return pivot;
        }else if(k < left ){
            return qselect(arr, start, left-1, k);
        }else{
            return qselect(arr, left+1, end, k);
        }
    }

    public int[] swap(int[] a, int left, int right){
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
        return a;
    }

    @Test
    public void kthLargTest(){
        int[] arr = {3,6,1,9,4}; // -> 3 1 6 9 4 -> 3 1 4 9 6 -> 3 1 4 | 9 6 -> 6 9 -> return 6
        kth kthLargeObj = new kth();
        int x = kthLargeObj.findKthLargest(arr,2);
        assertEquals(6,x);
    }

    @Test
    public void kthLargTest2(){
        int[] arr = {64,2,314,412,93,46,21,863,4,631,7,863};
        kth kthLargeObj = new kth();
        int x = kthLargeObj.findKthLargest(arr,4);
        assertEquals(412,x);
    }

    @Test
    public void asc(){
        int[] arr = {1,2,5,8,13}; // -> 1 2 5 8 13 -- >1 2 5 8 | 13 -> return 8
        kth kthLargeObj = new kth();
        int x = kthLargeObj.findKthLargest(arr,2);
        assertEquals(8,x);
    }

    @Test
    public void des(){
        int[] arr = {11,20,15,8,3}; // -> 3 20 15 8 11 ->3| 20 15 8 11->8 15 20 11->8 11 20 15
        // -> 3 8 11| 20 15 -> 20 15 -> 15 20
        kth kthLargeObj = new kth();
        int x = kthLargeObj.findKthLargest(arr,2);
        assertEquals(15,x);
    }

    @Test
    public void kthSmallest(){
        int[] arr = {64,2,314,93,46,21,863,4,631,7};
        kth kthLargeObj = new kth();
        int x = kthLargeObj.findKthSmallest(arr,4);
        assertEquals(21,x);
    }
}
