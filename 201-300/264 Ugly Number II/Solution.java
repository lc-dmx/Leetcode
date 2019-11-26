class Solution {
    public int nthUglyNumber(int n) {
        int[] result = new int[n];
        result[0] = 1;

        int i2 = 0, i3 = 0, i5 = 0;
        int temp2 = 2;
        int temp3 = 3;
        int temp5 = 5;

        for (int i = 1; i < n; i++) {
            int temp = Math.min(temp2, Math.min(temp3, temp5));
            result[i] = temp;

            if (temp == temp2) {
                i2++;
                temp2 = result[i2] * 2;
            }

            if (temp == temp3) {
                i3++;
                temp3 = result[i3] * 3;
            }

            if (temp == temp5) {
                i5++;
                temp5 = result[i5] * 5;
            }
        }
        return result[n - 1];
    }
}
