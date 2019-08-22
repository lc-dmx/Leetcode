首先要知道能走完整个环的前提是gas的总量要大于cost的总量，这样才会有起点的存在。
假设开始设置起点start = 0, 并从这里出发，如果当前的gas值大于cost值，就可以继续前进.
此时到下一个站点，剩余的gas加上当前的gas再减去cost，看是否大于0，若大于0，则继续前进。
当到达某一站点时，若这个值小于0了，则说明从起点到这个点中间的任何一个点都不能作为起点，则把起点设为下一个点，继续遍历。
当遍历完整个环时，当前保存的起点即为所求。代码如下：

# Solution 1
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, rest = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            rest += gas[i] - cost[i];

            if (rest < 0) {
                start = i + 1;
                rest = 0;
            }
        }
        return (sum >= 0) ? start : -1;
    }
}

我们也可以从后往前遍历，用一个变量mx来记录出现过的剩余油量的最大值，total记录当前剩余油量的值，start还是记录起点的位置。
当total大于mx的时候，说明当前位置可以作为起点，更新start，并且更新mx。为啥呢？
因为我们每次total加上的都是当前位置的油量减去消耗，如果这个差值大于0的话，说明当前位置可以当作起点，因为从当前位置到末尾都不会出现油量不够的情况，
而一旦差值小于0的话，说明当前位置如果是起点的话，油量就不够，无法走完全程，所以我们不更新起点位置start。
最后结束后我们还是看totoa是否大于等于0，如果其小于0的话，说明没有任何一个起点能走完全程，因为总油量都不够，参见代码如下：

# Solution 2
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int sum = 0, max = -1, start = 0;
        for (int i = gas.length - 1; i >= 0; i--) {
            sum += gas[i] - cost[i];

            if (sum > max) {
                max = sum;
                start = i;
            }
        }
        return (sum >= 0) ? start : -1;
    }
}
