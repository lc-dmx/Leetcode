# Solution 1
总体思路是：我们以i为分界，求在prices[0:i]交易一次的最大值和在prices[i:n]交易一次的最大值，然后相加即可.
为此，我们遍历两趟prices:
首先我们正向遍历prices，以prices[i]为卖出价，保留minprice = min(prices[0:i])为买进价格，求得交易一次在prices[0:i]的最大值.
然后我们反向遍历prices，以prices[i]为买进价，保留maxprice = max(prices[i:n])为卖出价格，求得交易一次在prices[i:n]的最大值
我们将对应位置的值相加，其最大值即为交易两次的总利润最大值.
class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len < 2) return 0;
        int [] maxBefore = new int[len];
        int min = prices[0];
        for(int i = 1; i < len; i++){
            maxBefore[i] = Math.max(maxBefore[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        int max = prices[len - 1];
        int ret = 0;
        for(int i = len - 2; i >= 0; i--){
            //找到后面最大的价格
            max = Math.max(prices[i], max);
            //利润 = 最大价格 - 当前价格 + 此时交易时第一次的利润
            //取最大值
            ret = Math.max(ret, max - prices[i] + maxBefore[i]);
        }
        return ret;
    }
}

# Solution 2
我们仍然使用动态规划来完成，事实上可以解决非常通用的情况，也就是最多进行k次交易的情况。
这里我们先解释最多可以进行k次交易的算法，然后最多进行两次我们只需要把k取成2即可。

我们还是使用“局部最优和全局最优解法”。我们维护两种量，一个是当前到达第i天可以最多进行j次交易，最好的利润是多少（global[i][j]），
另一个是当前到达第i天，最多可进行j次交易，并且最后一次交易在当天卖出的最好的利润是多少（local[i][j]）。

下面我们来看递推式，全局的比较简单，
global[i][j]=max(local[i][j],global[i-1][j])，
也就是取当前局部最好的，和过往全局最好的中大的那个（因为最后一次交易如果包含当前天一定在局部最好的里面，否则一定在过往全局最优的里面）。

对于局部变量的维护，递推式是
local[i][j]=max(global[i-1][j-1]+max(diff,0),local[i-1][j]+diff)，
也就是看两个量，第一个是全局到i-1天进行j-1次交易，然后加上今天的交易，如果今天是赚钱的话（也就是前面只要j-1次交易，最后一次交易取当前天），
第二个量则是取local第i-1天j次交易，然后加上今天的差值（这里因为local[i-1][j]比如包含第i-1天卖出的交易，所以现在变成第i天卖出，
并不会增加交易次数，而且这里无论diff是不是大于0都一定要加上，否则就不满足local[i][j]必须在最后一天卖出的条件了）。

上面的算法中对于天数需要一次扫描，而每次要对交易次数进行递推式求解，所以时间复杂度是O(n*k)，如果是最多进行两次交易，那么复杂度还是O(n)。
空间上只需要维护当天数据皆可以，所以是O(k)，当k=2，则是O(1)。代码如下：

class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length < 2) return 0;
        int[] local = new int[3];
        int[] global = new int[3];

        for (int i = 0; i < prices.length - 1; i++) {
            int diff = prices[i + 1] - prices[i];
            for (int j = 2; j >= 1; j--) {
                local[j] = Math.max(global[j - 1] + (diff > 0 ? diff : 0), local[j] + diff);
                global[j] = Math.max(local[j], global[j]);
            }
        }
        return global[2];
    }
}

# Solution 3
class Solution {
    public int maxProfit(int[] prices) {
        int[][] local = new int[prices.length][3];
        int[][] global = new int[prices.length][3];

        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= 2; j++) {
                local[i][j] = Math.max(global[i - 1][j - 1] + Math.max(diff, 0), local[i - 1][j] + diff);
                global[i][j] = Math.max(global[i - 1][j], local[i][j]);
            }
        }

        return global[prices.length - 1][2];
    }
}
