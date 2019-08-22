两个数组
# Solution 1
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] leftToRight = new int[len];
        int[] rightToLeft = new int[len];

        for (int i = 0; i < len - 1; i++) {
            if (ratings[i] < ratings[i + 1]) {
                leftToRight[i + 1] = leftToRight[i] + 1;
            }
        }

        for (int i = len - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                rightToLeft[i - 1] = rightToLeft[i] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += Math.max(leftToRight[i], rightToLeft[i]);
        }
        return sum + len;
    }
}

一个数组
# Solution 2
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] leftToRight = new int[len];

        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftToRight[i] = leftToRight[i - 1] + 1;
            }
        }

        //不一样
        int sum = leftToRight[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                leftToRight[i] = Math.max(leftToRight[i], leftToRight[i + 1] + 1);
            }
            sum += leftToRight[i];
        }

        return sum + len;
    }
}
