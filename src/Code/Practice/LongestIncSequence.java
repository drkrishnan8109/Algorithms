package Code.Practice;

/**
 * Created by developer on 10/1/17.
 */
public class LongestIncSequence {
    /** Modification of Binary Search
     * -- Works only for sorted array !
     * BS + cases when key lies between (mid-1) and (mid) OR (mid) and (mid+1)
     * Find smallest element that is larger than or equal to key
     */
    public int findCeil(int[] arr, int left, int right, int key) {
        if (left < 0 || right > arr.length-1 || left > right)
            return -1;

        int mid = (left + right) / 2;
        if (arr[mid] == key) return mid;

        if (key < arr[mid]) {
            // Find if key lies between mid and mid -1
            if(key > arr[mid-1] && left >= mid-1) return mid;
            else return findCeil(arr, 0, mid - 1, key);
        }
        else{
            //Find if key lies between mid and mid+1
            if(key < arr[mid+1] && mid+1<=right) return mid;
            else return findCeil(arr, mid + 1, right, key);
        }
    }


    public void findLIS(int[] A, int size){
        int[] prev = new int[size];
        int[] tailIndices = new int[size];

        tailIndices[0]=0;
        int len=0; //len is the largest curr location of tail indices
        for(int i=1;i<size;i++){
            /**Case 1: if elmnt is smallest seen
             i.e., new smallest value
             */
            if(A[i]<A[tailIndices[0]])
                tailIndices[0]=i;

            /** Case 2: if elmnt is greatest, just append to longest sequence
             i.e., next element found
             */
            else if(A[i]>A[tailIndices[len]]){
                prev[i]=tailIndices[len];
                len++;
                tailIndices[len]=i;
            }

            /** Case 3: Otherwise
             * if element lies in between current sequence,
             * find the ceil and replace it with this element's index
             */
        else{
                int pos = findCeil(A,0,len,A[i]);
                if(pos==0){
                    prev[pos]=-1;
                    tailIndices[pos]=i;
                }
                if(pos>0) {
                    prev[i]=tailIndices[pos-1];
                    tailIndices[pos]=i;
                }
            }
        }
        System.out.println("Longest Inc Seq length is: "+ (len+1));
        System.out.println("Longest Inc Seq in reverse order is:");
        for (int i = tailIndices[len]; i >= 0; i = prev[i]){
            System.out.print(A[i]+" ");
        }
    }

    public static void main(String args[]){
        LongestIncSequence lis = new LongestIncSequence();
        int[] ceilArrEg = { 2, 5, 6, 7, 11, 13, 60};
        int x = lis.findCeil(ceilArrEg,0,6,12);
        System.out.println("Ceil index is:" + x + " and ceil is:" + ceilArrEg[x]);
        int arr[] = { 2, 5, 3, 7, 11,4,6,8,9};
        lis.findLIS(arr,arr.length);
    }

    /**
     * i varies from:      0 1 2 3 4  5 6 7 8
     * Example     A:      2 5 3 7 11 4 6 8 9
     *
     * prevIndices:          0 1 2 3 4 4
     * tailIndices:        0 1
     * tailIndices:        0 1   3 4
     * tailIndices:        0 5   3 4
     * tailIndices:        0 3   3 4
     *
     * */
}