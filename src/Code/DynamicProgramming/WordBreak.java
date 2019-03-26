package Code.DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by drkrishnan on 12.04.2018.
 */
public class WordBreak {

    /**
     *
     * Usecase: Suppose we have a list of websites after crawling.
     * We want to find what kind of websites are most popular. . for example if
     * news or games is popular. Then create a disctionary of what we look for
     * See if the domain name of the websites can be broken to find this dictionary words
     *
     * urls => www.indiatoday.com, www.globalnews.com
     * dict => "news", "today","game", "games", "global"
     *
     * // Use recursion & backtracking
     * IMP !! To find ALL POSSIBLE combinations in any questions, think about back tracking
     * after recursive call.
     *
     * indiatoday
     * i
     *
     * */

    //Make list of possible combination of dictionary words
    public ArrayList<String> possibleDictWords(String str, List<String> dict) {
        ArrayList<String> res = new ArrayList<String>();

        possibleDictWordsRec(0, str, dict, res, "");
        return res;
    }

    public void possibleDictWordsRec(int start, String str, List<String> dict,
                                                  ArrayList<String> res,
                                                  String path) {

        //BC
        if(start==str.length()) {
            res.add(path);
            System.out.println(path);
            return;
        }
        //indiatoday
        //i , ndiatoday

        StringBuilder sb = new StringBuilder();
        for(int i=start;i<str.length();i++) {
                sb.append(str.charAt(i));
                if(dict.contains(sb.toString())) {
                    possibleDictWordsRec(i+1,str,dict,res,path+" "+sb.toString());
                }
        }
    }

    public boolean canBreak(String s, List<String> dict) {
        boolean[] dp = new boolean[s.length()+1];

        dp[0]=true;

        for(int i=1;i<= s.length();i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] && dict.contains(s.substring(j,i))) {
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

    public static void main(String args[]) {
        WordBreak wb = new WordBreak();
        String str = "leetcode";
        String str2= "indiatoday";
        String str3= "catsanddogs";

        List<String> dict = Arrays.asList("leet","code","i","in", "ndia","today", "cat", "cats",
                "and", "sand", "dogs");

        wb.possibleDictWords(str3,dict);
    }
}
