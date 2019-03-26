package Code.Practice;

import java.util.ArrayList;

/**
 * Created by D on 9/24/17.
 * This class implements finding all powersets of a given set of Strings
 */
public class PowerSet {
    // Hint: works on set,index -- loop exits at end of index
    //{a,b,c} -> {{},{a},{b},{c},{a,b},{b,c},{c,a},{a,b,c}} -> 8 -> O(2^n)
    //"" -> { {} } -> When i reach end of Set
    //c + powersets of base case -> {  {},{c} }
    //b + powersets of C -> { {},{c},{b},{b,c} }
    //a + powersets of b,c -> { {},{c},{b},{b,c},{a},{a,c},{a,b},{a,b,c} }

    public ArrayList<ArrayList<String>> getPowerSet(ArrayList<String> set, int index){
        ArrayList<ArrayList<String>> powerSet;
        //Base Case
        //here an extra count is needed for index,
        // which is restored to correct value after this recursive call returns
        // note index goes till 3 here, then return with empty ps; then index is 2
        // i.e, - correct array index for last elmt
        if(set.size()==index)
        {
            powerSet = new ArrayList<ArrayList<String>>();
            powerSet.add(new ArrayList<String>());
            return powerSet;
        }
        //recurse
        powerSet =  getPowerSet(set, index + 1);
        String item = set.get(index);

        //need a newlist to store only each recursion specific list since we loop on powerSet
        ArrayList<ArrayList<String>> moreSubSet = new ArrayList<ArrayList<String>>();

        for(ArrayList<String> subset : powerSet){
            //I need another set bcs i to keep subset's contents as itself,
            // and add more contents to it
            ArrayList<String> tempSubSet = new ArrayList<String>();
            tempSubSet.addAll(subset);
            tempSubSet.add(item);

            moreSubSet.add(tempSubSet);
        }
        powerSet.addAll(moreSubSet);

        if(index==0)
        {
            for(ArrayList<String> subset : powerSet){
                String allMembers = "{}";
                for(String str : subset){
                    allMembers = allMembers + "," + str;
                }
                System.out.println(allMembers);
                System.out.println(System.lineSeparator());
            }
        }
        return powerSet;
    }

    public static void main(String args[]){
        PowerSet ps = new PowerSet();
        ArrayList<String> set = new ArrayList<String>();
        set.add("a");set.add("b");set.add("c");
        System.out.println("Size of set:" + set.size());
        System.out.println("at index:" + set.get(1));
        ps.getPowerSet(set,0);
    }
}
