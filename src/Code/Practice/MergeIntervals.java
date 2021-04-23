package Code.Practice;

import java.util.*;

/**
 * Created by developer on 1/17/18.
 *
 * Scheduler
 */
public class MergeIntervals {
//Very important handling of Collection of primitive arrays
public int[][] merge(int[][] intervals) {
    if (intervals.length <= 1)
        return intervals;

    // Sort by ascending starting point
    Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));

    List<int[]> result = new ArrayList<>();
    int start= intervals[0][0], end = intervals[0][1];
    //1,3 2,5 3,6 6,6 7,9 10,11==> start=7,end=9   // o/p: [1,6], [7,9]
    for (int[] interval : intervals) {
        if (end >= interval[0]) // Overlapping intervals, move the end if needed
            end = Math.max(end, interval[1]);
        else {                             // Disjoint intervals, add the new interval to the list

            result.add(new int[] {start,end});
            start = interval[0];
            end= interval[1];
        }
    }
    result.add(new int[]{start,end});

    return result.toArray(new int[result.size()][2]);
}
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1)
            return intervals;

        // Sort by ascending starting point using an anonymous Comparator
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));

        List<Interval> result = new LinkedList<Interval>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for (Interval interval : intervals) {
            if (interval.start <= end) // Overlapping intervals, move the end if needed
                end = Math.max(end, interval.end);
            else {                     // Disjoint intervals, add the previous one and reset bounds
                result.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }

        // Add the last interval
        result.add(new Interval(start, end));
        return result;
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}