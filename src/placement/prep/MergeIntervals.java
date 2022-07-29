package placement.prep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    private static class Interval {
        int start;
        int finish;

        Interval (int start, int finish) {
            this.start = start;
            this.finish =finish;
        }

        @Override
        public String toString() {
            return "Interval{" +
                    "start=" + start +
                    ", finish=" + finish +
                    '}';
        }
    }

    private static List<Interval> mergeIntervals (Interval[] intervals) {
        List<Interval> list = new ArrayList<>();
        if (intervals.length == 0) return list;

        Arrays.sort(intervals, (a, b) -> a.start - b.start);
        int start = intervals[0].start;
        int end = intervals[0].finish;

        for (Interval i: intervals) {
            if (i.start <= end) {
                end = Math.max(end, i.finish);
            }
            else {
                list.add(new Interval(start, end));
                start = i.start;
                end = i.finish;
            }
        }
        list.add(new Interval(start, end));
        return list;
    }

    public static void main(String[] args) {
        Interval[] arr = new Interval[]{new Interval(1,4),
                                        new Interval(3,5),
                                        new Interval(6,8),
                                        new Interval(8,9),
                                        new Interval(10,12)};
        List<Interval> list = mergeIntervals(arr);
        System.out.println(list.toString());
    }
}
