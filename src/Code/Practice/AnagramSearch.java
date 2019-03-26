package Code.Practice;

/**
 * Created by Dhanya on 11/12/17.
 * Find if agiven pattern or its anagram is present in the text.
 * If yes, print the index where match begins.
 */
public class AnagramSearch {

    public static final int MAX = 256;

    public void search (String pat, String txt) {
        int[] countP = new int[MAX];
        int[] countT = new int[MAX];

        int M = pat.length();
        int N = txt.length();

        //Set count of all characters in pattern in both countP array
        // and countT array
        for (int i = 0; i < M; i++) {
            countP[pat.charAt(i)]++;
            countT[txt.charAt(i)]++;
        }

        // Instead of checking index at 0, we could include compare func
        // at begining of next for loop; but then compare after exiting next for loop
        // bcs otherwise the last window is never compared
        if (compare(countP, countT))
            System.out.println("Found at index 0");

        for (int i = M; i < N; i++) {
            //Slide the window and set and unset chars count accordingly
            countT[txt.charAt(i)]++;
            countT[txt.charAt(i-M)]--;
            if (compare(countP, countT))
                System.out.println("Found at index" + (i - M));
        }
    }

        public boolean compare(int[] arr1, int[] arr2){
            for(int i=0; i<MAX; i++) {
                if(arr1[i]!=arr2[i])
                    return false;
            }
        return true;
    }

    public static void main(String args[]){
        String pattern = "LGE";
        String text = "GOOGLE";
        AnagramSearch anagramSearch = new AnagramSearch();
        anagramSearch.search(pattern,text);
    }
}
