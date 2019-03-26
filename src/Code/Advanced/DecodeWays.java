package Code.Advanced;

/**
 * Created by drkrishnan on 31.03.2018.
 */
public class DecodeWays {
    private int dfsCache(String s) {
        int n = s.length();
        int[] cache = new int[n + 1];
        for (int i = 0; i <= n; i++)
            cache[i] = -1;
        return dfsCache(s, 0, cache);
    }

    private int dfsCache(String s, int pos, int[] cache) {
        if (pos < s.length() && s.charAt(pos) == '0')
            return 0;
        if (pos == s.length())
            return 1;
        if (cache[pos] != -1)
            return cache[pos];
        int nWay = dfsCache(s, pos + 1, cache);
        int val = 0;
        if (pos + 1 < s.length())
            val = Integer.parseInt(s.substring(pos, pos + 2));
        if (val >= 10 && val <= 26)
            nWay += dfsCache(s, pos + 2, cache);
        cache[pos] = nWay;
        return nWay;
    }
}