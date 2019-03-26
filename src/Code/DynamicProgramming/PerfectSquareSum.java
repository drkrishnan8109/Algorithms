package Code.DynamicProgramming;

/**
 * Created by drkrishnan on 12.04.2018.
 *
 * sum=8
 *
 * dp[n+1] to store all numbers exhaustively upto the sum
 * base cases:
 * dp[0]=0
 * dp[1]=1
 * dp[2]=2
 * dp[3]=3
 * Remaining : dp[i]=i
 *
 * From x= 1 to i
 * dp[i] = Min {dp[i], 1+dp[i - x*x]}
 *
 * From 1 to i, for each value find min
 *   0 1 2 3 4 5 6 7 8
 *dp 0 1 2 3 4
 *
 */
public class PerfectSquareSum {

    public int perfectSquare(int sum) {
        int[] dp = new int[sum+1];

        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;

        int temp=0;
        for(int i=4;i<sum;i++) {
            dp[i]=i;

            for(int x=1; x<=i; x++) {
                temp=x*x;
                if(temp>i)
                    break;
                dp[i]= Math.min(dp[i], 1+dp[i-temp]);
            }
        }
        return dp[sum];
    }
}
