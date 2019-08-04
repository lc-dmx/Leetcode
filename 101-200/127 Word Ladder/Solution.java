这道题是套用BFS同时也利用BFS能寻找最短路径的特性来解决问题。

把每个单词作为一个node进行BFS。当取得当前字符串时，对他的每一位字符进行从a~z的替换，如果在字典里面，就入队，并将下层count++，
并且为了避免环路，需把在字典里检测到的单词从字典里删除。这样对于当前字符串的每一位字符安装a~z替换后，在queue中的单词就作为下一层需要遍历的单词了。

正因为BFS能够把一层所有可能性都遍历了，所以就保证了一旦找到一个单词equals（end），那么return的路径肯定是最短的。

像给的例子 start = hit，end = cog，dict = [hot, dot, dog, lot, log]. 按照上述解题思路的走法就是：

level = 1    hit   dict = [hot, dot, dog, lot, log]

  ait bit cit ... xit yit zit ，  hat hbt hct ... hot ... hxt hyt hzt ，  hia hib hic ... hix hiy hiz

level = 2    hot  dict = [dot, dog, lot, log]

  aot bot cot dot ...  lot ... xot yot zot，hat hbt hct ... hxt hyt hzt，hoa hob hoc ... hox hoy hoz

level = 3    dot lot  dict = [dog log]

  aot bot ... yot zot，dat dbt ...dyt dzt，doa dob ... dog .. doy doz，

  aot bot ... yot zot，lat lbt ... lyt lzt，loa lob ... log... loy loz

level = 4   dog log dict = [] 

  aog bog cog
  
level = 5   cog  dict = []


class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) {
            return 0;
        }

        Set<String> set = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int level = 1;
        int curnum = 1;
        int nextnum = 0;

        while (!queue.isEmpty()) {
            String temp = queue.poll();
            curnum--;

            for (int i = 0; i < temp.length(); i++) {
                StringBuilder sb = new StringBuilder(temp);
                for (char j = 'a'; j <= 'z'; j++) {
                    sb.setCharAt(i, j);
                    
                    if (set.contains(sb.toString())) {
                        if (sb.toString().equals(endWord)) {
                            return level + 1;
                        }

                        set.remove(sb.toString());
                        queue.offer(sb.toString());
                        nextnum++;
                    }
                }
            }

            if (curnum == 0) {
                curnum = nextnum;
                nextnum = 0;
                level++;
            }
        }
        return 0;
    }
}
