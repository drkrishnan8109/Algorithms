package Code.Phoenix.Searching;

class SearchRange {
        public int[] notpresent() {
            int[] res = new int[2];
            res[0] = -1;
            res[1] =-1;
            return res;
        }
        public int[] searchRange(int[] nums, int target) {
            // 5778810

            int n=nums.length;
            int[] res= new int[2];
            if(n==0 || (n==1 && nums[0]!=target)) return notpresent();
            if(n==1 && nums[0]==target) {
                res[0]=0;
                res[1]=0;
                return res;
            }

            return searchRangeRec(nums,target,0,n-1,res);
        }

        public int[] searchRangeRec(int[] nums,int target,int l,int r,int[] res) {

            int mid=l + (r-l)/2;

            while(l<=r && l>=0 && r<=nums.length-1) {
                if(nums[mid]== target) {
                    int begin=mid,end=mid;
                    while (begin-1 >=0 && nums[begin-1] == target) begin--;
                    while (end+1 < nums.length && nums[end+1] == target) end++;
                    return new int[]{begin, end};
                }
                if(nums[mid]<target)
                    return searchRangeRec(nums,target,mid+1,r,res);
                else
                    return searchRangeRec(nums,target,l,mid-1,res);
            }
            return notpresent();
        }
    }