class Solution {
    public int maxPoints(int[][] points) {
        Point[] allPoints = new Point[points.length];
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < 2; j++) {
                allPoints[i] = new Point(points[i][0], points[i][1]);
            }
        }

        int res = 0;
        for (int i = 0; i < allPoints.length; i++) {
            Map<Map<Integer, Integer>, Integer> map = new HashMap<>();
            int duplicate = 1;
            for (int j = i + 1; j < allPoints.length; j++) {
                if (allPoints[i].x == allPoints[j].x && allPoints[i].y == allPoints[j].y) {
                    duplicate++;
                    continue;
                }
                int dx = allPoints[i].x - allPoints[j].x;
                int dy = allPoints[i].y - allPoints[j].y;
                int gcd = gcd(dx, dy);
                Map<Integer, Integer> temp = new HashMap<>();
                temp.put(dx / gcd, dy / gcd);
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            }

            res = Math.max(res, duplicate);
            for (Map.Entry<Map<Integer, Integer>, Integer> e : map.entrySet()) {
                res = Math.max(res, e.getValue() + duplicate);
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
