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

class WordDictionary {
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
    
    public boolean searchPrefix(String word, TrieNode cur, int pos) {        
        if (pos == word.length()) {
            return cur.getEndOfWord();
        }
        
        char temp = word.charAt(pos);
        
        if (temp == '.') {
            for (int i = 0; i < 26; i++) {
                if (!cur.containsKey((char)('a' + i))) continue;
                TrieNode node = cur.get((char)('a' + i));
                if (searchPrefix(word, node, pos + 1)) {
                    return true;
                }
            }
        } else {
            if (cur.containsKey(temp) && searchPrefix(word, cur.get(temp), pos + 1)) {
                return true;
            }
        }
        return false;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchPrefix(word, root, 0);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
