package Code.DynamicProgramming;

/**
 * Created by drkrishnan on 10.04.2018.
 *
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.

 For example, given the array [2,3,-2,-4,5,6],
 the contiguous subarray [2,3] has the largest product = 6.

 ***** only for neg numbers, take MAX of LOCAL_MIN numbers
 [2,3,-2,-4,-5,-6]
  2 6 -2 48 -5
      -12

 [-10  2   3   4 ]
  -10  2   6   24
  -10 -20 -60 -240
 int maxProduct(vector<int>& nums) {
    int localMax = nums[0];
    int localMin = nums[0];
    int maxProd = nums[0];

    for(int i = 1; i < nums.size(); i ++){
        if(nums[i] > 0){
            localMax = max(localMax * nums[i], nums[i]);
            localMin = min(localMin * nums[i], nums[i]);
        } else{
           ***** only for neg numbers, take MAX of LOCAL_MIN numbers
            int localMaxNeg = max(localMin * nums[i], nums[i]);
            localMin = min(localMax * nums[i], nums[i]);
            localMax = localMaxNeg;
        }
     maxProd = max(maxProd, localMax);
    }

    return maxProd;
 }


 */
public class MaxProductContiguousSubArray {


}
