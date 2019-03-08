/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        LinkedList<Interval> result = new LinkedList<>();
        result.offerLast(newInterval);
        for (Interval interval : intervals) {
            if (interval.end < newInterval.start) {
                newInterval = result.pollLast();
                result.offerLast(interval);
                result.offerLast(newInterval);
            } else if (interval.start > newInterval.end) {
                result.offerLast(interval);
            } else {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(interval.end, newInterval.end));
                result.pollLast();
                result.offerLast(newInterval);
            }
        }
        return result;
    }
}
