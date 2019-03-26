package Code.Practice;

import java.util.Stack;

/**
 * Created by developer on 1/28/18.
 * Given two strings, with 'B' representing backspace. Check if the final strings match
 * */

public class MatchStringsGoogleQstn {

    public boolean matchString(String s1, String s2){
        Stack<Character> stack1= new Stack<>();
        Stack<Character> stack2= new Stack<>();

        // abcdBB  aBacd
        //
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!='B')
                stack1.push(s1.charAt(i));
            else {
                if(!stack1.isEmpty())
                    stack1.pop();
            }
        }

        for(int i=0;i<s2.length();i++){
            if(s2.charAt(i)!='B')
                stack2.push(s2.charAt(i));
            else {
                if(!stack2.isEmpty())
                    stack2.pop();
            }
        }

        if(stack1.size()!=stack2.size()) return false;
        while(!stack1.isEmpty() && !stack2.isEmpty()){
            Character c1= stack1.pop();
            Character c2= stack2.pop();

            if(c1.charValue()!=c2.charValue())
                return false;
        }
        return true;
    }

    public static void main(String args[]){
        MatchStringsGoogleQstn mt = new MatchStringsGoogleQstn();
        boolean b = mt.matchString("abcdBB","abgB");
        System.out.print(b);
    }
}
