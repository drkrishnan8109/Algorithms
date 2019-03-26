package Code.DynamicProgramming;

/**
 * Created by drkrishnan on 11.04.2018.
 *
 *   1 2 3 4 2
 *   1
 *
 *   numWays[n] = numWays[n-1] + getValid(n-2)
 *   12 = 1 + 1 = 2
 *   123= 2 + 1  =>123, 12 3, 1 23
 *
 *   but here since we are accessing 2 previous digits,
 *   we need count to have length n+1 to avoid acccessing Array Index out of bounds
 */

//DP solution
public class DecodeWays {

    public int decodeWays(char[] arr) {
        int[] count = new int[arr.length+1];

        count[0]=1;
        count[1]=1;

        for(int i=2;i< arr.length;i++) {
            //If last digit is 1 or more, then numWays is same as previous num
            if(arr[i-1]>'0')
                count[i]=count[i-1];
            // If second last digit is smaller than 2 and last digit is
            // smaller than 7, then last two digits form a valid character
            if(arr[i-2]=='1' || (arr[i-2]=='2'&& arr[i-1]<'7'))
                count[i]+=count[i-2];
        }
        return count[arr.length];
    }

}
