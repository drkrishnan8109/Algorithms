package Code.Practice;

/**
 * Created by Dhanya on 11/10/2017
 *
/** O(m*n) by dynamic prgmmng*/
/* Dynamic Programming Java implementation of LCS problem */
public class LongestCommonSubSequence
{

    /* Returns length of LCS for X[0..m-1], Y[0..n-1] */
    int lcs( char[] X, char[] Y, int m, int n )
    {
        int L[][] = new int[m+1][n+1];

    /* Following steps build L[m+1][n+1] in bottom up fashion. Note
         that L[i][j] contains length of LCS of X[0..i-1] and Y[0..j-1] */
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                if (i == 0 || j == 0)
                    L[i][j] = 0;
                else if (X[i-1] == Y[j-1])
                    L[i][j] = L[i-1][j-1] + 1;
                else
                    L[i][j] = max(L[i-1][j], L[i][j-1]);
            }
        }

        //printLCS(L,X,Y);
        return L[m][n];
    }

    /* Utility function to get max of 2 integers */
    int max(int a, int b)
    {
        return (a > b)? a : b;
    }

    public static void main(String[] args)
    {
        LongestCommonSubSequence lcs = new LongestCommonSubSequence();
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X=s1.toCharArray();
        char[] Y=s2.toCharArray();
        int m = X.length;
        int n = Y.length;

        System.out.println("Length of LCS is" + " " +
                lcs.lcs( X, Y, m, n ) );


        String str = "ABCDA";
        String rev_str = "ADCBA";
        int x = lcs.lcs(str.toCharArray(),rev_str.toCharArray(),str.length(),rev_str.length());
        System.out.println("Min num of insertions to make string palindrome is:" + (str.length() - x));

        //this works because we find the longest possible matching,
        // then total - unmatches -> this gives how many further matches is required to
        // make a palindrome from this string
        String str2 = "XYABFBTSRDA";
        String rev_str2 = "ADRSTBFBAYX";
        int x2 = lcs.lcs(str2.toCharArray(),rev_str2.toCharArray(),str2.length(),rev_str2.length());
        System.out.println("Min num of insertions to make string palindrome is:" + (str2.length() - x2));
    }


}