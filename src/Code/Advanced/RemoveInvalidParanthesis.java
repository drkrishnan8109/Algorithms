package Code.Advanced;

import java.util.*;

/**
 * Created by drkrishnan on 06.05.2018.
 *
 *  /*
 Consider edges cases
 "", "abc", ")(", "()(", "))"

 Using DFS can work only if one character is mismatched. It cant handle cases like:
 ")(ab" - here it will not remove two invalid characters.

 Hence use BFS!
*/


public class RemoveInvalidParanthesis {

    public List<String> removeInvalidParentheses(String s) {

        if(s==null)
            return new ArrayList<String>();
        if(s.length()==0)
            return new ArrayList<String>(Arrays.asList(""));
        if(isValid(s))
            return new ArrayList<String>(Arrays.asList(s));

        Set<String> visited = new HashSet<>();
        Set<String> result = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        String temp;
        queue.add(s);
        visited.add(s);
        boolean level=false;

        while(!queue.isEmpty()) {
            s = queue.poll();

            if(isValid(s)) {
                //dont return becasue we need to find all combinations of string
                //at this level (here level means one char removal, or 2 chars removal etc)
                level=true;
                result.add(s);
            }
            if(level)
                continue;

            for(int i=0;i<s.length();i++) {
                if(s.charAt(i)!='(' && s.charAt(i)!=')')
                    continue;
                temp = s.substring(0, i) + s.substring(i + 1);
                if (!visited.contains(temp)) {
                    queue.add(temp);
                    visited.add(temp);
                }
            }
        }
        return new ArrayList<String>(result);
    }

    public String remove(String s, int i) {
        if(s.charAt(i)!='(' && s.charAt(i)!=')')
            return s;
        if(i==0 && s.length()>1)
            return s.substring(1);
        else if(i==s.length()-1)
            return s.substring(0,s.length()-1);
        else
            return s.substring(0,i)+s.substring(i+1);
    }

    public boolean isValid(String str){
        int cnt = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == '(')
                cnt++;
            else if (str.charAt(i) == ')')
                cnt--;
            if (cnt < 0)
                return false;
        }
        return (cnt == 0);
    }
        public static void main(String args[]) {
            String s = "))()";
            RemoveInvalidParanthesis rObj = new RemoveInvalidParanthesis();
            List<String> arr = new ArrayList<>();
            arr = rObj.removeInvalidParentheses(s);

            for(String k:arr) {
                System.out.println(k);
            }
        }

    }
