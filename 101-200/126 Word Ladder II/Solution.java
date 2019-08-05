我们可以将路径化为有向图，然后将有向图中从beginWord至endWord的最短路径全部枚举出来。
这里需要考虑最合适的数据结构。graph的话我们通过Map<String,Set<String>>来记录节点和从该节点出发可以到达的其它节点。在题中的含义也就是s1所能转换的所有s2。
至于如何生成该有向图，则需要通过广度优先算法，利用队列来实现。将每一层的string分别入栈。如果遇到endWord则至该层结尾广度优先算法结束。

class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new LinkedList<>();
        
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord)) return result;

        Map<String, Set<String>> graph = new HashMap<>();

        Set<String> cur = new HashSet<>();
        cur.add(beginWord);
        
        while (!cur.isEmpty() && !cur.contains(endWord)) {
            set.removeAll(cur);
            Set<String> next = new HashSet<>();

            for (String str : cur) {
                graph.put(str, new HashSet<>());

                for (int i = 0; i < str.length(); i++) {
                    StringBuilder sb = new StringBuilder(str);
                    for (char j = 'a'; j <= 'z'; j++) {
                        sb.setCharAt(i, j);

                        if (set.contains(sb.toString())) {
                            next.add(sb.toString());
                            graph.get(str).add(sb.toString());
                        }
                    }
                }
            }
            cur = next;
        }

        if (!cur.contains(endWord)) return result;
        LinkedList<String> link = new LinkedList<>();
        link.add(beginWord);
        build(result, link, beginWord, endWord, graph);
        return result;
    }

    private void build(List<List<String>> result, LinkedList<String> link, String beginWord, String endWord,
                                     Map<String, Set<String>> graph) {
        if (beginWord.equals(endWord)) {
            result.add(new LinkedList<>(link));
            return;
        }

        if (graph.containsKey(beginWord)) {
            for (String next : graph.get(beginWord)) {
                link.offer(next);
                build(result, link, next, endWord, graph);
                link.remove(next);
            }
        }
    }
}
