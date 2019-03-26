package Code.DynamicProgramming;

/**
 * Created by drkrishnan on 11.04.2018.
 *
 * Refer Tushar Roys video youtube
 *
 * Max profit Buy and sell with atmost k transactions
 *
 * Max profit can be obtained on a day by two ways
 * 1. Dont do any transaction on this day, and keep profit of previous day
 * 2. Do transaction on this day
 *    => diff + profit with one less transaction
 i.e,
 # a) No Transaction on the day. We pick the value from day - 1
 # b) Max profit made by selling on the day plus the cost of the previous transaction, considered over m days


 *    i is num of trasactions
 *    j is current day
 *    m is the olden day (ie old transaction day considered)
 *    m = 0 to j
 *    T[i-1][m] is max profit with one less trasaction on m-th day
 *
 *    T[i][j] = Max { T[i][j-1],
 *                    price[j]-price[m]  + T[i-1][m]
 *                   }
 *
 *             day prices
            2 5 7 1 4 3 1 3
            0 0 0 0 0 0 0 0 0
    tras:   1 0 3 5 5 5 5 5 5
            2 0 3 5 5 8 8 8 8
            3 0 3 5 5 8 8 8 10
 */
public class BuyAndSellStockIV {

    public int buySell(int[] prices, int k) {
        int[][] T = new int[prices.length][k];

        int num_trans = k+1;
        int num_days = prices.length;

        for(int transaction=1;transaction<num_trans;transaction++) {
            for(int day=1; day<num_days; day++) {
                T[transaction][day] = Math.max(T[transaction][day-1],
                            max_price_with_trans(prices,day,T,transaction)
                          );
            }
        }
        return T[num_trans-1][k-1];
    }

    public int max_price_with_trans(int[] prices, int day, int[][] T, int trans) {
        int res=0;
        for(int m=0;m<day;m++) {
            res = Math.max(res, prices[day]-prices[m] + T[trans-1][m]);
        }
        return res;
    }

    public static void main(String args[]) {
        BuyAndSellStockIV b = new BuyAndSellStockIV();
        int[] prices = new int[] {2,5,7,1,4,3,1,3};
        int x=b.buySell(prices,3);
        System.out.print(x);
    }
}
