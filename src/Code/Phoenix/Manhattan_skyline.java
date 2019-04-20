package Code.Phoenix;
import java.util.*;

public class Manhattan_skyline {

        public int solution(int[] H) {
            //1. As long as incresaing blocks, the number of blocks is increased and just push to stack
            //2. When smaller block is coming, keep poping until we see a equal/smaller block
            //3. special case is when you see same size, then do nothing

            Stack<Integer> st = new Stack<>();
            int num_blocks =0;
            for(int i=0;i<H.length;i++) {
                //Writing this while loop for popping first is the key for smaller code,
                // otherwise the code becomes too large and dirty, but still possible
                while(!st.isEmpty() && st.peek()>H[i])
                    st.pop();
                if(!st.isEmpty() && st.peek()==H[i])
                    continue;
                else{
                    num_blocks++;
                    st.push(H[i]);
                }
            }
            return num_blocks;
        }
    }