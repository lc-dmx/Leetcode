class TrieNode {
    TrieNode[] list;
    String str;
    boolean isEnd;
    
    TrieNode() {
        this.list = new TrieNode[26];
        this.str = "";
        this.isEnd = false;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();

        TrieNode root = new TrieNode();

        for (int i = 0; i < words.length; i++) {
            insert(root, words[i]);
        }

        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, result, root, visited);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int i, int j, List<String> result, TrieNode root, boolean[][] visited) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] ||
            root.list[board[i][j] - 'a'] == null) {
            return;
        }

        root = root.list[board[i][j] - 'a'];
        if (root.isEnd) {
            result.add(root.str);
            root.isEnd = false;
        }
        
        visited[i][j] = true;

        dfs(board, i + 1, j, result, root, visited); 
        dfs(board, i - 1, j, result, root, visited); 
        dfs(board, i, j + 1, result, root, visited); 
        dfs(board, i, j - 1, result, root, visited);
        
        visited[i][j] = false;
    }
    
    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if (node.list[temp - 'a'] == null) {
                node.list[temp - 'a'] = new TrieNode();
            }
            node = node.list[temp - 'a'];
        }
        node.isEnd = true;
        node.str = word;
    }
}
