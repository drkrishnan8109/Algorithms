package Code.Advanced;

/**
 * Created by drkrishnan on 07.05.2018.
 *
 * Given an input string (s) and a pattern (p),
 * implement wildcard pattern matching with support for
 * '?' and '*'.
 *
 * '?' Matches any single character.
   '*' Matches any sequence of characters
 * (including the empty sequence).
 *
 * Eg : s="abccccaaa", p = "*a?***c*"
 *
 * Solution:
 * 1. If characters of p and s match, increase index of both and recurse
 * 2. If p has ? increase index of both and recurse
 * 3. If p has *
 *      a. increase index until we reach non-star character
 *      b. Recurse for next valid character of both & see if it returns true.
 *         If didnt return, then keep traversing strings characters & recurse
 *         i.e only increase strings character and recurse again
 */
public class WildCardMatching {

    public boolean match(String s, String p) {
        return matchRec(s,p,0,0);
    }
    public boolean matchRec(String s, String p, int sIndx, int pIndx) {
        if(sIndx==s.length() && pIndx==p.length())
            return true;

        if(sIndx<s.length() && p.charAt(pIndx)==s.charAt(sIndx) || p.charAt(pIndx)=='?')
            return matchRec(s,p,sIndx+1,pIndx+1);
        else if(sIndx<s.length() && p.charAt(pIndx)=='*') {
            while(p.charAt(pIndx)=='*')
                pIndx++; //Traverse to next non-star character
            while(sIndx<s.length()) {
                if(matchRec(s,p,sIndx,pIndx))
                    return true;
                sIndx++;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        WildCardMatching wM = new WildCardMatching();
        if(wM.match("xaaabc","***a?c"))
            System.out.println("true");
        else
            System.out.println("false");
    }
}
