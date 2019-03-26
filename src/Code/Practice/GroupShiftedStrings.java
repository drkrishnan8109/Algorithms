package Code.Practice;

import java.util.*;

/**
 * Created by developer on 1/26/18.
 */
public class GroupShiftedStrings {

    public static List<List<String>> grpShiftedString(ArrayList<String> ls) {
        List<List<String>> res = new ArrayList<>();
        if(ls==null || ls.size()==0) return res;

        // zab -> Make key i.e., a string of a-z, b-a
        // ab ba

        HashMap<String,ArrayList<String>> hmap = new HashMap<>();
        String key;

        for(String s: ls) {
            key="";
            //Make key for each string
            for(int i=1;i<s.length();i++) {
                int diff = s.charAt(i) - s.charAt(i - 1);
                // handle negative diff in case of smaller char - larger char
                if (diff < 0)
                    diff += 26;
                key += 'a' + diff;
            }
            if(!hmap.containsKey(key)) {
                ArrayList<String> val_ls = new ArrayList<String>();
                val_ls.add(s);
                hmap.put(key,val_ls);
            }
            else{
                hmap.get(key).add(s);
            }
        }

        for(Map.Entry<String, ArrayList<String>> map : hmap.entrySet()){
            List<String> subls = map.getValue();
            res.add(subls);
        }

        return res;
    }

    public static void main(String args[]) {
        ArrayList<String> s = new ArrayList<>(Arrays.asList("abc","bcd", "xz", "hj","za","bca", "jih"));
        List<List<String>> ll= new ArrayList<>();
        ll = grpShiftedString(s);

        for(List<String> lls: ll){
            for(String ss: lls){
                System.out.print(ss+",");
            }
            System.out.println("....");
        }
    }
}
