class TrieNode {
    private TrieNode[] children;
    private final int RANGE = 26;
    private boolean isEndOfWord;

    public TrieNode() {
        children = new TrieNode[RANGE];
    }

    public TrieNode get(char ch) {
        return children[ch - 'a'];
    }

    public void put(char ch, TrieNode node) {
        children[ch - 'a'] = node;
    }

    public boolean containsKey(char ch) {
        return children[ch - 'a'] != null;
    }

    public boolean getEndOfWord() {
        return isEndOfWord;
    }

    public void setEndOfWord() {
        isEndOfWord = true;
    }
}

class Trie {
    private TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if (!node.containsKey(temp)) {
                node.put(temp, new TrieNode());
            }
            node = node.get(temp);
        }
        node.setEndOfWord();
    }

    public TrieNode searchPrefix(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if (!node.containsKey(temp)) {
                return null;
            } else {
                node = node.get(temp);
            }
        }
        return node;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.getEndOfWord();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
