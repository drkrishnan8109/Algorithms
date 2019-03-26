package Code.Practice;

/**
 * Created by Dhanya on 11/26/17.
 *
 * This algo has TC is O(n2) and SC is O(1) -- not dynamic programming
 * With each letter as centre, expand outwards and find longest palindrome using a maxlength
 * Find even length palindrome, with low = i-1 and high = i
 * Find odd length palindrome, with low = i-1 and high = i+1;
 *
 * remember the start index of palindrome as start = low
 *
 */
public class LongestPalindrome {

    public void findLongestPalindromeSubstring(String str) {

        int n = str.length();
        int low, high,maxlength=1;
        int start=0;

        for(int i=1;i<n;i++) {
            low= i-1;
            high= i;

            //find even length palindrome
            while(low>=0 && high<n
                    && str.charAt(low) == str.charAt(high)) {
                    if(maxlength < (high - low +1)){
                        start = low ;
                        maxlength = high - low +1;
                    }
                low--;
                high++;
            }

            low = i-1;
            high = i+1;

            //find even length palindrome
            while(low>=0 && high<n
                    && str.charAt(low) == str.charAt(high)) {
                if(maxlength < (high - low +1)){
                    start = low ;
                    maxlength = high - low +1;
                }
                low--;
                high++;
            }

        }
        System.out.println(str.substring(start, start + maxlength));
    }

    public static void main(String[] args) {

        String str = "forgeeksskeegfor";
       LongestPalindrome longP = new LongestPalindrome();
        longP.findLongestPalindromeSubstring(str);
    }

}
