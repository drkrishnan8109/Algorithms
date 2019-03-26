package Code.Practice;

import java.util.Random;

/**
 * Created by Dhanya on 9/29/17.
 */
public class NoArithemetic {

    //Dont swap with XOR when both numbers are eual, then XOR makes both of them as 0
    public void swapWithXOR(int a, int b){
        if(a!=b) {
        a = a^b;
        b = b^a;
        a = a^b;
        System.out.println("Swapping function gives: a is: " + a + " and b is : " + b);
    }
    }

    public int add(int a, int b){
        if(b == 0) return a;
        int sum = a^b; // Only add, no carrying
        // -- Only add: any ith bit will be 0
        // only if ith bits of both a and b are same --> XOR

        int carry = (a&b) << 1; // Only do carrying, dont add
        // -- Only carry: any ith bit will be 1 only if previous bit i.e., i-1 th bit
        // is of a and b are both 1s --> AND, shifted

        return add(sum,carry); //recurse
    }

    public int rand7(){
        //There is not deterministic solution for this
        while(true){
            //equal probability of 0 to 20 + equal probability of 0-4
            //so tatoally 0 to 24 numbers
            // i.e, to generate 0 to 6, do 6 times call of rand5() ??
            int num = 5 * rand5() + rand5();
            if(num < 21)
                return num % 7;
        }
    }

    public int rand5(){
        Random rand = new Random();
        //exclusive of 5
        return rand.nextInt(5);
    }

    public static void main(String args[]){
        NoArithemetic obj = new NoArithemetic();
        obj.swapWithXOR(3,2);
        int x = obj.add(3,4);
        System.out.print("Add without arithmetic gives:" + x);
    }
}
