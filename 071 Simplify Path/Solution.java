class Solution {
    public String simplifyPath(String path) {
        StringBuilder result = new StringBuilder();

        String[] parts = path.split("/");
        Deque<String> queue = new LinkedList<>();

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].equals("..")) {
                queue.poll();
            } else if (!parts[i].equals(".") && !parts[i].equals("")) {
                queue.push(parts[i]);
            }
        }

        while (!queue.isEmpty()) {
            result.append("/").append(queue.pollLast());
        }
        return result.length() == 0 ? "/" : result.toString();
    }
}
