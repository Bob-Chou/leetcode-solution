class TrieNode {
    private TrieNode[] children;
    private boolean isWord;

    public TrieNode() {
        children = new TrieNode[26];
        isWord = false;
    }

    public void addWordReversely(String word) {
        TrieNode cur = this;
        for (int i = word.length() -1; i >= 0; --i) {
            char ch = word.charAt(i);
            if (cur.children[ch - 'a'] == null) {
                cur.children[ch - 'a'] = new TrieNode();
            }
            cur = cur.children[ch - 'a'];
        }
        cur.isWord = true;
    }

    public boolean isWord() {
        return isWord;
    }

    public TrieNode childAt(char ch) {
        return children[ch - 'a'];
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        TrieNode vocabulary = new TrieNode();
        for (String word : wordDict) {
            vocabulary.addWordReversely(word);
        }
        boolean[] helper = new boolean[s.length() + 1];
        helper[0] = true;
        for (int i = 1; i < s.length() + 1; ++i) {
            TrieNode cur = vocabulary;
            for (int j = i; j > 0; --j) {
                char ch = s.charAt(j-1);
                cur = cur.childAt(ch);
                if (cur == null) break;
                if (cur.isWord()) helper[i] = helper[j-1];
                if (helper[i]) break;
            }
        }

        return helper[s.length()];
    }
}
