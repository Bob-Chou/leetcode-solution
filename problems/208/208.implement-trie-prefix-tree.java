class Trie {
    private boolean isWord;
    private Trie[] children;
    /** Initialize your data structure here. */
    public Trie() {
        isWord = false;
        children = new Trie[26];
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) cur.children[ch - 'a'] = new Trie();
            cur = cur.children[ch - 'a'];
        }
        cur.setTrue();
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie cur = this;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) return false;
            cur = cur.children[ch - 'a'];
        }
        return cur.getValue();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie cur = this;
        for (int i = 0; i < prefix.length(); ++i) {
            char ch = prefix.charAt(i);
            if (cur.children[ch - 'a'] == null) return false;
            cur = cur.children[ch - 'a'];
        }
        return cur.searchChildren();
    }

    public boolean searchChildren() {
        if (isWord) return true;
        for (Trie child : children) {
            if (child != null) {
                if (child.searchChildren()) return true;
            }
        }
        return false;
    }

    public void setTrue() {
        isWord = true;
    }

    public void setFalse() {
        isWord = false;
    }

    public boolean getValue() {
        return isWord;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
