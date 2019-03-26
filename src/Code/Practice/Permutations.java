package Code.Practice;
import java.util.ArrayList;

/**
 * Created by developer on 9/24/17.
 */
public class Permutations {
    //Hint: first character appended at each locations
    // "abcd" - Take first character and attach at each locations of each words
    // which are in the permutations of the remaining
    /*
    *  bcd cbd cdb bdc dbc dcb
    *  abcd bacd bcad bcda
    *  acdb cabd cbad cbda
    * */
    public static void main(String args[]){
        Permutations perm = new Permutations();
        ArrayList<String> words = perm.getPermutations("abcd");
        for(String w : words){
            System.out.println(w);
        }
        System.out.println(words.size());
    }

    public ArrayList<String> getPermutations(String str){
       // if(str == null) return null;
        ArrayList<String> permutations = new ArrayList<String>();
        if(str.length()==0){
            permutations.add("");
            return permutations;
        }

        //recurse
        char first= str.charAt(0);
        //String remaining = (str.length()>1)? str.substring(1) : "";
        // it is ok without the above check, bcs if length is 0, we never reach here!
        String remaining = str.substring(1);

        ArrayList<String> words = getPermutations(remaining);

        for(String word: words){
            for(int i=0; i<=word.length();i++){
                String eachPerm = insertCharAt(word, first, i);
                permutations.add(eachPerm);
            }
        }
        return permutations;
    }

    public String insertCharAt(String word, char c, int i){
        String start = word.substring(0,i);// it is excluding i
        String end = word.substring(i);
        return start + c + end;
    }
}
