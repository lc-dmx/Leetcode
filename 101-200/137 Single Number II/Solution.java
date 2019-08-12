假设问题改为：只有一个数出现两次，其余出现三次，我们只需要返回high即可。
又假如：有一个数出现一次或者两次，其余出现三次，我们只需要返回low|high即可。
此外，不只是出现三次，出现五次、七次也可以用构造真值表的方法来解决，只需要增加输入位数即可。

class Solution {
    public int singleNumber(int[] nums) {
        int seenOnce = 0, seenThird = 0;
        for (int i = 0; i < nums.length; i++) {
             seenOnce = ~seenThird & (seenOnce ^ nums[i]);
             seenThird = ~seenOnce & (seenThird ^ nums[i]);
        }

        return seenOnce;
    }
}
