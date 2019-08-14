class Solution {
    boolean flag = true;
    Stack<Integer> stack = new Stack<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
            if (visit[i] != 1) {
                dfs(adjList, i, visit);
            }
            if (!flag) {
                return new int[0];
            }
        }

        int[] res = new int[numCourses];
        int i = 0;
        while (!stack.isEmpty()) {
            res[i++] = stack.pop();
        }
        return res;
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
        stack.push(node);
    }
}
