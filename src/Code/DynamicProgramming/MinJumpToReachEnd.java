package Code.DynamicProgramming;

/**
 * Created by drkrishnan on 11.04.2018.
 *
 * 1.Linear: O(n)
 * 2.DP: O(n2)
 *
 * Linear: O(n) -Easy
 * Maintain a ladder with max length possible further.
 * Maintain stairs travelled in the current ladder
 * & update jump whenever we change ladder
 *
 * Array:     2 3 1 1 2 4 2 0 1 1
 * stair      2 1 0 0 2 1 0 0 0 0
 * ladder     2 3 2 1 2 4 3 2 1 1
 * jump           1       2
 *
 *
 * DP: O(n2)
 *
 * From 0 to end,
 *  min num of jump to reach each i = Min {jump[each nodes tat can reach i] + 1
 *                                         }
 * Note the from_indices in a separate array only if we need the final pathjump
 *
 * Index:     0 1 2 3 4 5
 * Array:     2 3 1 1 2 4 2 0 1 1
 * MinJump:   0 1 1 2 2 3 3 4 4 4
 * FromIndx: -1 0 0 1 1 4 4 5 5 5
 */
public class MinJumpToReachEnd {

    public int minJumLinear(int[] arr) {
        int ladder = arr[0]; //Keep track of largest ladder
        int stairs = arr[0]; //Keep track on steps available in current ladder
        int jump=1;

        for(int level=1; level<arr.length;level++) {
            if(level==arr.length-1)
                return jump;
            if(stairs==0 && ladder==0)
                return jump;
            //Update ladder if bigger ladder found
            if(ladder< level + arr[level])
                ladder = level + arr[level];
            stairs--; // use the stairs
            //If no stairs left, jump to new ladder
            if(stairs==0) {
                jump++;
                stairs=ladder - level;
            }
        }
    return jump;
    }


    public int minJumpDP(int[] arr) {
        int[] minJump = new int[arr.length];
        int[] from_indices = new int[arr.length];
        minJump[0]=0;
        from_indices[0]=-1;

        for( int i=1;i<arr.length;i++) {
            for(int j=0;j<i;j++) {
                //if i is reachable from j
                if(isReachable(i,j,arr)) {
                    //if index was not needed, then we need only following line
                    //minJump[i]= Math.min(minJump[i], minJump[j]+1);

                    if(minJump[i]!=0 || (minJump[j]+1) < minJump[i]) {
                        from_indices[i]=j;
                        minJump[i] = minJump[j]+1;
                    }
                }
            }
        }
        printFunc(minJump);
        printFunc(from_indices);

        return minJump[arr.length-1];
    }

    //If index i is reachable from index j
    public boolean isReachable(int i, int j, int[] arr) {
        if((j+arr[j]) < i)
            return false;
        return true;
    }

    public void printFunc(int[] arr) {
        for (int i=0;i<arr.length;i++)
            System.out.print(arr[i]);
        System.out.println();
    }

    public static void main(String args[]) {
        MinJumpToReachEnd mJump = new MinJumpToReachEnd();
        int[] arr = new int[] {2,3,1,1,2,4,2,0,1,1};
        System.out.println(mJump.minJumpDP(arr));
        System.out.println("abcd".substring(0,1));
        System.out.println("abcd".substring(0,0));
    }
}
