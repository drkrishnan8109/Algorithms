package Code.Practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by developer on 1/17/18.
 *
 * Scheduler
 */
public class MergeIntervals {


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

    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty() || intervals == null || intervals.size() == 1) return intervals;
        int n = intervals.size();

        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                if (a.start < b.start)
                    return -1;
                else if (a.start > b.start)
                    return 1;
                else {
                    if (a.end < b.end)
                        return -1;
                    else if (a.end > b.end)
                        return 1;
                    else return 0;
                }
            }
        };

        //First sort!
        Collections.sort(intervals, comp);
        //[1,3],[2,6],[8,10],[15,18]
        Interval begin = intervals.get(0);
        Interval curr;
        ArrayList<Interval> res = new ArrayList<Interval>();

        for (int i = 1; i < n; i++) {
            curr = intervals.get(i);
            if (begin.end < curr.start) {
                res.add(begin);
                begin = curr;
            } else {
                begin.start = Math.min(begin.start, curr.start);
                begin.end = Math.max(begin.end, curr.end);
            }
        }
        res.add(begin);
        return res;
    }
}