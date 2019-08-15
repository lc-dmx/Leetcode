dfs
# Solution 1
class Solution {
    boolean flag = true;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        //初始化所有节点均未被访问过
        int[] visit = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            visit[i] = -1;
        }

        //建立邻接表
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        for (int i = 0; i < numCourses; i++) {
            dfs(adjList, i, visit);
            if (!flag) {
                return false;
            }
        }
        return flag;
    }

    private void dfs(List<List<Integer>> adjList, int node, int[] visit) {
        visit[node] = 0;

        for (int i = 0; i < adjList.get(node).size(); i++) {
            if (visit[adjList.get(node).get(i)] == -1) {
                dfs(adjList, adjList.get(node).get(i), visit);
            } else if (visit[adjList.get(node).get(i)] == 0) {
                flag = false;
            }
        }

        visit[node] = 1;
    }
}

入度
# Solution 2
class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        //建立邻接表
        for (int i = 0; i < prerequisites.length; i++) {
            adjList.get(prerequisites[i][1]).add(prerequisites[i][0]);
            indegree[prerequisites[i][0]] += 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        //添加入度为0的点
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int i = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            i++;

            //把该点的所有邻居的入度减1
            for (Integer neighbor : adjList.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        if (i == numCourses) {
            return true;
        }

        return false;
    }
}
