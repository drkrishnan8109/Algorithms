package Code.Practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by developer on 1/28/18.
 */
public class ThreeSum {
        public List<List<Integer>> threeSum(int[] nums) {

            if(nums==null || nums.length==0 ) return new ArrayList<List<Integer>>(){};
            List<List<Integer>> res= new ArrayList<>();

            int n=nums.length;
            int low,high;
            Arrays.sort(nums);
            if((3*nums[n-1]<0) || (3*nums[0]>0))
                return new ArrayList<List<Integer>>(){};
            //[-1,0,1,2,-1,-4]
            //[-4,-1,-1,0,2]
            // -4 -1 2

            for(int i=0;i<n;i++){
                if(i!=0 && nums[i]==nums[i-1]) continue;
                low=i+1;
                high=n-1;
                while(low<high && low<n && high>0){
                    if(nums[i]+nums[low]+nums[high] ==0) {
                        List<Integer> ls= new ArrayList<>();
                        res.add(ls);
                        res.get(res.size()-1).addAll(Arrays.asList(nums[i],nums[low],nums[high]));
                        low++;high--;
                        //Avoid duplicates - IMP
                        while(low<n && nums[low]==nums[low-1])
                            low++;
                        while(high>0 && nums[high]==nums[high+1])
                            high--;
                    }
                    else if((0-nums[i]) < (nums[low]+nums[high])){
                        high--;
                    }
                    else
                        low++;
                }
            }
            return res;
        }
    }

