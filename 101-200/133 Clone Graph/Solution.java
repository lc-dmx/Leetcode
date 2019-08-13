/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/

# Solution 1
class Solution {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        map.put(node, new Node(node.val, new ArrayList<>()));

        for (Node neighbor : node.neighbors) {
            if (map.containsKey(neighbor)) {
                map.get(node).neighbors.add(map.get(neighbor));
            } else {
                map.get(node).neighbors.add(cloneGraph(neighbor));
            }
        }
        return map.get(node);
    }
}

For one, it wouldn't be thread safe. If you had multiple threads calling this same function, they'd be writing to the same map, and clobbering each other. 
This implementation is safer, because it gives each call its own copy of a HashMap, and they don't have to worry about it. 
The question doesn't explicitly say to be concerned about concurrency, but it never hurts to be proactive.
# Solution 2

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return helper(node, map);
    }

    private Node helper(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }

        if (map.containsKey(node)) {
            return map.get(node);
        } else {
            Node clone = new Node(node.val, new ArrayList<>());
            map.put(node, clone);
            for (int i = 0; i < node.neighbors.size(); i++) {
                clone.neighbors.add(helper(node.neighbors.get(i), map));
            }
            return clone;
        }
    }
}
