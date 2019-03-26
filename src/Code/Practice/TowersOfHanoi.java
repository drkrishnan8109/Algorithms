package Code.Practice;

import org.junit.Test;

/**
 * Created by Dhanya on 10/8/17.
 */
public class TowersOfHanoi {
    public void move(int n, String startPole, String inter, String endPole) {
        if(n == 1) {
            System.out.println("Move 1 from "+startPole + " to "+ endPole);
        }
        else {
            move(n - 1, startPole, endPole, inter);
            System.out.println("Move " + n + " from " + startPole + " to " + endPole);
            move(n - 1, inter, startPole, endPole);
        }
    }


    @Test
    public void TestHanoi() {
        move(3, "src", "inter","dest");

    }

}
