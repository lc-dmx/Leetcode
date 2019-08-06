# Solution 1 并查集
class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        UnionFind uf = new UnionFind(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], i);

                if (map.containsKey(nums[i] - 1)) {
                    uf.union(i, map.get(nums[i] - 1));
                }

                if (map.containsKey(nums[i] + 1)) {
                    uf.union(i, map.get(nums[i] + 1));
                }
            }
        }

        return uf.maxLength();
    }
}

class UnionFind {
    int[] parent;
    public UnionFind(int length) {
        parent = new int[length];
        for (int i = 0; i < length; i++) {
            parent[i] = i;
        }
    }

    // 查找根节点
    public int find(int num) {
        int proxy = num;
        //返回根节点
        while (parent[proxy] != proxy) {
            proxy = parent[proxy];
        }

        //路径压缩
        int i = num, temp;
        while (i != proxy) {
            temp = parent[i];
            parent[i] = proxy;
            i = temp;
        }
        return proxy;
    }

    public void union(int numX, int numY) {
        int parentX = find(numX);
        int parentY = find(numY);

        //判断numX, numY是否联通; 不连通任意指定parentY为parentX的上级
        if (parentX != parentY) {
            parent[parentX] = parentY;
        }
    }

    public int maxLength() {
        /**
         *  借助一个count数组（初始值为0，作用是计算每个索引的子结点数）
         *  从0遍历到nums-1，找出每个索引的根结点的索引，将其+1
         *  最后遍历count数组，找到最大值即为最长连续序列
         */
        int result = 0;
        int[] count = new int[parent.length];

        for (int i = 0; i < count.length; i++) {
            result = Math.max(result, ++count[find(i)]);
        }

        return result;
    }
}

# Solution 2 使用一个集合HashSet存入所有的数字，遍历数组中的每个数字，如果其在集合中存在，那么将其移除。
分别用两个变量pre和next算出其前一个数跟后一个数，在集合中循环查找：
如果pre在集合中，那么将pre移除集合，然后pre再自减1，直至pre不在集合之中；
对next采用同样的方法，那么next-pre-1就是当前数字的最长连续序列，更新res即可。

这里再说下，为啥当检测某数字在集合中存在当时候，都要移除数字，这是为了避免大量的重复计算。
就拿题目中的例子来说吧，我们在遍历到4的时候，会向下遍历3，2，1，如果都不移除数字的话，遍历到1的时候，还会遍历2，3，4。
同样，遍历到3的时候，向上遍历4，向下遍历2，1，等等等。
如果数组中有大量的连续数字的话，那么就有大量的重复计算，十分的不高效，所以我们要从HashSet中移除数字，代码如下：

public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Set<Integer> s = new HashSet<>();
        for (int num : nums) s.add(num);
        for (int num : nums) {
            if (s.remove(num)) {
                int pre = num - 1, next = num + 1;
                while (s.remove(pre)) --pre;
                while (s.remove(next)) ++next;
                res = Math.max(res, next - pre - 1);
            }
        }
        return res;
    }
}

# Solution 3 我们也可以采用哈希表来做，刚开始HashMap为空，遍历所有数字，
如果该数字不在HashMap中，那么我们分别看其左右两个数字是否在HashMap中，如果在，则返回其哈希表中映射值，若不在，则返回0。
虽然我们直接从HashMap中取不存在的映射值，也能取到0，但是一旦取了，就会自动生成一个为0的映射，那么我们这里在for循环的开头判断如果存在映射就跳过的话，就会出错。
然后将left+right+1作为当前数字的映射，并更新res结果，同时更新num-left和num-right的映射值。

下面来解释一下为啥要判断如何存在映射的时候要跳过，这是因为一旦某个数字创建映射了，说明该数字已经被处理过了，那么其周围的数字很可能也已经建立好了映射了，
如果再遇到之前处理过的数字，再取相邻数字的映射值累加的话，会出错。
举个例子，比如数组 [1, 2, 0, 1]，当0执行完以后，HashMap中的映射为 {1->2, 2->3, 0->3}，可以看出此时0和2的映射值都已经为3了，
那么如果最后一个1还按照原来的方法处理，随后得到结果就是7，明显不合题意。
还有就是，之前说的，为了避免访问不存在的映射值时，自动创建映射，我们使用m.count() 先来检测一下，只有存在映射，我们才从中取值，否则就直接赋值为0，参见代码如下：
public class Solution {
    public int longestConsecutive(int[] nums) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) continue;
            int left = map.getOrDefault(num - 1, 0);
            int right = map.getOrDefault(num + 1, 0);
            int sum = left + right + 1;
            map.put(num, sum);
            res = Math.max(res, sum);
            map.put(num - left, sum);
            map.put(num + right, sum);
        }
        return res;
    }
}
