package Code.Practice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by developer on 1/23/18.
 */
public class MaxSubSequence {

    // -7 0 1 2 3 4 5 6 7

    public List<Integer> findMaxSeq(int[] data) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        int bestStart=0, bestLength=1, maxSum=0;
        int currStart=0, currLength=0, currSum=0;

        int n=data.length;

        for (int i = 1; i < n; i++) {
            if (currSum < 0) { //Reset everything to slide window
                currStart = i;
                currLength = 1;
                currSum = data[i];
            } else { //Increase window interval
                currSum += data[i];
                currLength++;
            }

            // Find the best seq seen till now
            if (currSum > maxSum) {
                bestStart = currStart;
                bestLength = currLength;
                maxSum = currSum;
            }
        }
        res.add(bestStart);
        res.add(bestLength);
        res.add(maxSum);
        return res;
    }
}