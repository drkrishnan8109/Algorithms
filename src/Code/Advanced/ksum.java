package Code.Advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by developer on 2/3/18.
 */

public class ksum {
static List<List<Integer>> kSum2(int[] a, int target, int k) {
        List<List<Integer>> result = new ArrayList<>();
        if (a == null || k > a.length || k < 2) return result;
        Arrays.sort(a);
        kSum_Recursive(a, target, 0, k, result, new ArrayList<>());
        return result;
        }

static void kSum_Recursive(int[] a, int target, int start, int k, List<List<Integer>> result, List<Integer> path) {
    if (k == 2) {                                                   // 2 Sum
        int left = start;
        int right = a.length - 1;
        while (left < right) {
            if (a[left] + a[right] > target) right--;
            else if (a[left] + a[right] < target) left++;
            else {
                result.add(new ArrayList<>(path));
                result.get(result.size() - 1).addAll(Arrays.asList(a[left], a[right]));
                left++;
                right--;
                while (left < right && a[left] == a[left - 1]) left++;
                while (left < right && a[right] == a[right + 1]) right--;
            }
        }
    } else {                                                          // k Sum
        for (int i = start; i < a.length - k + 1; i++) {
            if (i > start && a[i] == a[i - 1]) continue;
            path.add(a[i]);
            kSum_Recursive(a, target - a[i], i + 1, k - 1, result, path);
            path.remove(path.size() - 1);                      // backtracking
        }
    }
}
}