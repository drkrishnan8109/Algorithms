package Code.Practice;

import java.util.HashSet;
import java.util.Set;

/***
 *
 * Write an algorithm to determine if a number n is happy.
 *
 * A happy number is a number defined by the following process:
 *
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 *
 */
public class SlowFastPointerProblems {

    public boolean happynumber(int n) {

        int slow = sumOfSquares(n);
        int fast = sumOfSquares(slow);

        while (slow != fast) {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(slow);
            fast = sumOfSquares(slow);

            if(fast==1)
                return true;
        }
        if(slow==1)
            return true;
        else
            return false;

    }

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(true){
            int sum = sumOfSquares(n);
            if(sum==1)
                return true;
            else if(set.contains(sum))
                return false;
            else{
                set.add(sum);
                n=sum;
            }
        }
    }

    public int sumOfSquares(int n){
        int rem,sum=0;
        while(n>0){
            rem=n%10;
            sum+=rem*rem;
            n=n/10;
        }
        return sum;
    }
}
