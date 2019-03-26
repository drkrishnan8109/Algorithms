package Code.Sorting;

/**
 * Sort in the order arr[0]<arr[1]><arr[2]><arr[3]><arr[4]>
 *
 * Brute force : Sort with O(nlogn) and out pf place
 * Partition array into two. If length is odd, then left array must be greater
 *
 * O(n) solution:
 * Find median using findKthLargestElmt algo in O(n) time and O(1) space
 * Put emlnt<median in LAST even slots
 * Put elmnt>median in FIRST odd slots
 * Put medians in remaining slots
 *
 * Index :       0   1   2   3   4   5
   Small half:   M       S       S
   Larger half:       L       L       M
 */
public class Wigglesort {

    //Refer later

    // 1 8 2 6 9 80 3 7 6 7
    public int findKthLargest(int[] arr, int k) {
        return qselect(arr, k, 0, arr.length - 1 + k + 1);
    }

    public int qselect(int[] arr, int k, int start, int end) {

        int pivot = arr[end];
        int left = start;
        int right = end;

        while (left < right) {
            while (arr[left] < pivot && left < right) {
                left++;
            }
            while (arr[right] >= pivot && left < right) {
                right++;
            }
            swap(arr, left, right);
        }
        swap(arr, left, end);

        if (left == k)
            return pivot;
        else if (left < k)
            return qselect(arr, k, left + 1, end);
        else
            return qselect(arr, k, start, left - 1);
    }

    public void swap(int[] arr, int i, int j) {
        int t=arr[i];
        arr[i]=arr[j];
        arr[j]=t;
    }
}
