package Code.Phoenix.BS;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Problem: You are given n binary values x0, x1, . . . , xn−1, such that xi ∈ {0, 1}. This array represents holes in a roof
 * (1 is a hole). You are also given k boards of the same size. The goal is to choose the optimal (minimal) size of the boards
 * that allows all the holes to be covered by boards
 *
 *
 * we know we can use k boards, but we dont know which size is the minimum size if k number of boards are allowed.
 * For example suppose only 1 board is allowed, and holes are at index 0 and 9, then size 10 is needed
 * Now if 2 boards were allowed, and holes are at index 0 and 9, then size 1 is enough!
 *
 * Use Binary search to  greedily find out the size.
 * Let size of board be mid, and find number of boards required. if that num<k, then loop: because if size l can fix holes,
 * check greedily if l/2 can fix too.
 * */
public class   MinBoardToFillHoles {

    //O(n logn)
    public int minSizeBoard(int[] A, int k) {

        int begin=1; // Note: begin must be 1, so that size(i.e. mid) doesnt become 0 -> bcs mid will represent the size, not the index

        int end=A.length,mid=0, result=0;

        while(begin<=end) { // Note: mid will represent the size, not the index, hence end must be A.length and not A.len-1 !!!
            mid = (begin+end)/2;
            //size being mid
            if(numBoards(A,mid) <= k) {
                end = mid-1;
                result = mid; // result has to be stored bcs we are greedily checking and replacing value of mid in further loops.
            }
            else
                begin = mid+1;  // That means we are either checking for 1/2 size of A, else we check for 3/4 of A (bcs mid shows 3/4 th index)
        }
        return result;
    }

    //Find number of Boards required to fill hole if size of board is given: by traversing left to right greedily
    //O(n)
    public int numBoards(int[] A, int size ){

        int boards=0, lastIndex=-1;

       for(int i=0;i<A.length;i++) {
            if(A[i]==1)  {
                boards++;
                i = i + size - 1;
            }
        }
        return boards;
    }

    @Test
    public void test() {
        int[] A = new int[] {1,0,0,0,0,1};
        MinBoardToFillHoles obj = new MinBoardToFillHoles();
        int size = obj.minSizeBoard(A,1);
        assertEquals(6,size);
        size = obj.minSizeBoard(A,2);
        assertEquals(1,size);

    }
}

