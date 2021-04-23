package Code.Practice;

/**
 * Created by developer on 1/12/18.
 * Qstn: There is an integer array nums sorted in ascending order (with distinct values).
 *
 * Prior to being passed to your function, nums is rotated at an unknown pivot index k (0 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
 *
 * Given the array nums after the rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
 */
public class ArrayRotation {
    public int search(int[] nums, int target) {
        //[4,5,6,7,0,1,2]
        return binarySearch(nums,0,nums.length-1,target);
    }

    public int binarySearch(int[] arr, int low,int high, int target) {
        //while(low<=high && low>=0 && high<arr.length) =>>=> here we will never need this 2nd and 3rd conditions
        // bcs then already low becomes greater than high
        while(low<=high) {
            int mid=low + (high-low)/2;
            if(target==arr[mid])
                return mid;

            if(arr[low] <= arr[mid]) {
                //left subarray in correct order
                if(target<arr[mid] && target>= arr[low])
                    high=mid-1;
                else
                    low=mid+1;
            }
            else {
                //right subarray in correct order
                if(target>arr[mid] && target<=arr[high])
                    low=mid+1;
                else
                    high=mid-1;
            }
        }
        return -1;
    }
}
