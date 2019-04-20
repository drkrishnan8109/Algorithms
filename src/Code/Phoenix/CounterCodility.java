package Code.Phoenix;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CounterCodility {

    /*
    * (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)
    * */

        public int[] solution(int N, int[] A) {
            int[] X = new int[N];

            int max = 0,curr=0;
            for(int i=0;i<A.length;i++) {
                if(A[i]<=N) {
                    curr = ++X[A[i]-1];
                    if(max< curr)
                        max= curr;
                }
                else if(A[i] == N+1){
                    setMaxArr(X,max);
                }
            }
            return X;
        }

        public void setMaxArr(int[] X,int max) {
            for(int i=0;i<X.length;i++) {
                if(X[i]!=max)
                    X[i]=max;
            }

        }

    @Test
    public void mergeTest(){
        // int[] A = {5,1,8,3,0,53,15,43};
        int[] A = {3, 4, 4, 6, 1, 4, 4};
        solution(5,A);
        }
    }

