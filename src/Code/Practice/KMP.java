package Code.Practice;

/**
 * Created by Dhanya on 11/25/17.
 *
 * KMP creates lps table for - longest proper prefix and suffix which is
 * less than the full string
 * O(n + m)
 * Space O(m), m is length of pattern
 *
 * pat =  AABABC
 */
public class KMP {

    public void findLPS(String pat, int[] lps, int m) {
        lps[0] = 0; //Bcs prefix of 1st char is 0
        int len = 0; // longest common substring

        int i=1;
        while(i<m) {
            if(pat.charAt(i)==pat.charAt(len)) {
                len++;
                lps[i] =len;
                i++;
            }
            else {
                if(len!= 0)
                    // index i is not updated & we go back until len is a match or len is zero
                    len = lps[len-1];
                else {
                    //If len is 0, we dont have any option than moving ahead with next character
                    lps[i] = len; //Dont forget to update lps
                    i++;
                }
            }
        }
    }

    public void KMPSearch(String pat, String text) {
        int m= pat.length();
        int[] lps = new int[m];
        findLPS(pat,lps,m);

        int n = text.length();
        int i=0,j=0; //i tracks text and j tracks pat

        while(i<n) {
            if(pat.charAt(j)==text.charAt(i)) {
                i++;
                j++;
            }
            if(j == m) {
                System.out.println("Found at index: " + (i-j));
                j = lps[j-1];
            }
            //Important to check bounds of i again as i might have increased above i.e.,if match
            else if(i<n && j<m && pat.charAt(j)!=text.charAt(i) ){
                if(j!=0){
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
        }}

    public static void main(String args[]) {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        new KMP().KMPSearch(pat, txt);
    }
}
