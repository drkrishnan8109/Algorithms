package Code.Practice;

/**
 * Created by Dhanya on 11/20/17.
 * O(mn)
 * Keeps source string as column and dest string as row
 * When there is a match, copy diagonal value
 * else 1 + min (diag,left, top)
 * eg CART to MARCH
 */
// A Dynamic Programming based Java program to find minimum
// number operations to convert str1 to str2
public class EditDistance
{
    static int min(int x,int y,int z)
    {
        if (x <= y && x <= z) return x;
        if (y <= x && y <= z) return y;
        else return z;
    }

    static int editDistDP(String str1, String str2, int m, int n)
    {
        // Create a table to store results of subproblems
        // size is +1 to consider empty strings
        int edit_dp[][] = new int[m+1][n+1];

        // Fill d[][] in bottom up manner
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i==0)
                    edit_dp[i][j] = j;  // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j==0)
                    edit_dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                 // i-1 and j-1 are the correct indices in str, bcs the dp table has
                // 0 i.e. empty set as the 1st row and coln
                // hence i in dp maps to i-1 in the str index
                else if (str1.charAt(i-1) == str2.charAt(j-1))
                    edit_dp[i][j] = edit_dp[i-1][j-1];

                    // If last character are different, consider all
                    // possibilities and find minimum
                else
                //prev col - insert
                //prev row - remove
                //diagonal - replace

                //Take min of diag, left and top
                    edit_dp[i][j] = 1 + min(edit_dp[i][j-1],  // Insert
                            edit_dp[i-1][j],  // Remove
                            edit_dp[i-1][j-1]); // Replace
            }
        }

        return edit_dp[m][n];
    }



    public static void main(String args[])
    {
        String str1 = "sunday";
        String str2 = "saturday";
        System.out.println( editDistDP( str1 , str2 , str1.length(), str2.length()) );
    }
}