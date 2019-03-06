/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 *     public int compareTo(Object o) {
 *         Interval p = (Interval)o;
 *         if (this.start < p.start) {
 *             return -1;
 *         } else if (this.start == p.start) {
 *             return 0;
 *         } else {
 *             return 1;
 *         }
 *     }
 * }
 */
class Solution {
    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }
    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> result = new LinkedList<>();
        for (Interval interval : intervals) {
            if (result.isEmpty() || result.getLast().end < interval.start) {
                result.add(interval);
            } else {
                result.getLast().end = Math.max(result.getLast().end, interval.end);
            }
        }
        return result;
    }
}
