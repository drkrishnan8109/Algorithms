package Code.Practice;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by developer on 1/11/18.
 * 236 is colorful bcs 2*3 is 6
 * Colorful numbers -- checks for all numbers, not the sequence to be colorful
 */
public class ColorfulNumbers {

    public int checkcolorful(int num) {
        int length = String.valueOf(num).length();
        int[] digits = new int[length];
        int index = length - 1;

        Set<Integer> productSet = new HashSet<Integer>();

        while (num > 0) {
            digits[index] = num % 10;
            if(productSet.contains(digits[index]))
            {
                System.out.println("Not a colorful number");
                return 0;
            }else{
                //System.out.println("Added "+digits[index]+" at "+index);
                productSet.add(digits[index]);
            }
            num = num / 10;
            index--;
        }
        for (int x = 1; x < length; x++) {
            int product = 1;
            for(int i=0;i<x;i++)
            {
                product = product*digits[i];
            }

            for (int y = x; y < length; y++) {
                if(productSet.contains( product * digits[y]))
                {
                    System.out.println("Not a colorful number");
                    //System.out.println("Not a colorful number "+ product * digits[y]+" exists");
                    return 0;
                }else{
                    //System.out.println("Added "+ product * digits[y]);
                    productSet.add( product * digits[y]);
                }
            }
        }
        System.out.println("Colorful number");
        return 1;
    }
    public static void main(String args[]) {
        ColorfulNumbers cn = new ColorfulNumbers();
        cn.checkcolorful(4208);
    }
}
