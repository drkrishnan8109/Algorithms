package Code.Phoenix;
import java.util.*;

/**
 * Instead of pushing the opening bracket, push its pair
 * Each time we see closing bracklet,
 *  1. Check if stack empty
 *  2. Compare if same closing is present in stack.peep
 * */
public class Brackets {
        public int solution(String S) {

            if(S==null)
                return 0;
            Stack<Character> st = new Stack<>();
            //()({{))
            //()(
            //)

            //

            for(char c: S.toCharArray()) {
                if(c == '(')
                    st.push(')');
                if(c == '[')
                    st.push(']');
                if(c == '{')
                    st.push('}');
                else if (c==')' || c==']' || c=='}') {
                    if(st.isEmpty())
                        return 0;
                    else {
                        if(c==st.peek())
                            st.pop();
                        else
                            return 0;
                    }
                }
            }
            if(!st.isEmpty())
                return 0;
            return 1;
        }
    }