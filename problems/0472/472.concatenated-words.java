class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();
        for (String w : words) {
            if (w.length() > 0)
                root.insert(w, 0);
        }
        List<String> ans = new LinkedList<>();
        for (String w : words) {
            if (root.check(root, w, 0, 0))
                ans.add(w);
        }
        return ans;
    }

    class Trie {
        void insert(String s, int start) {
            if (start == s.length()) {
                isWord = true;
            } else {
                int c = s.charAt(start) - 'a';
                if (children[c] == null)
                    children[c] = new Trie();
                children[c].insert(s, start + 1);
            }
        }
        boolean check(Trie root, String s, int start, int count) {
            if (start == s.length()) {
                return isWord && count > 0;
            }
            int c = s.charAt(start) - 'a';
            if (children[c] == null)
                return false;
            if (children[c].isWord) {
                if (root.check(root, s, start + 1, count + 1))
                    return true;
            }
            return children[c].check(root, s, start + 1, count);
        }
        boolean isWord = false;;
        Trie[] children = new Trie[26];
    }
}
