package Code.Practice;

/**
 * Created by developer on 1/13/18.
 */
public class IncreasingTriplet {

    public boolean incTriplet(int[] nums) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int z = nums[i];

            if (x >= z) {
                x = z;// update x to be a smaller value
            } else if (y >= z) {
                y = z; // update y to be a smaller value
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String args[]) {
        IncreasingTriplet ip = new IncreasingTriplet();
        int[] arr = new int[] {16,8,7,6,19,5,6,2,3,4};
        boolean b = ip.incTriplet(arr);
        System.out.println(b);
    }
}
