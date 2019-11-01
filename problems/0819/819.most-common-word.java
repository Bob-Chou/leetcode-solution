class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Trie trie = new Trie();
        for (String s : banned) {
            for (int i = 0; i < s.length(); ++i) {
                trie.insertAndSet(s, 0, -1);
            }
        }

        int maxFreq = 0;
        String maxFreqWord = null;

        for (String s : paragraph.toLowerCase().split("[^a-z]")) {
            if (!s.equals("")) {
                int cnt = trie.insertOrInc(s, 0);
                if (cnt > maxFreq) {
                    maxFreq = cnt;
                    maxFreqWord = s;
                }
            }
        }

        return maxFreqWord;
    }

    class Trie {
        public Trie[] chars = new Trie[26];
        public int count = 0;
        public void insertAndSet(String s, int i, int cnt) {
            if (i == s.length()) {
                this.count = cnt;
            } else {
                Trie t = chars[s.charAt(i) - 'a'];
                if (t == null)
                    t = new Trie();
                chars[s.charAt(i) - 'a'] = t;
                t.insertAndSet(s, i+1, cnt);
            }
        }
        public int insertOrInc(String s, int i) {
            if (i == s.length()) {
                if (count == -1)
                    return count;
                else
                    ++count;
                    return count;
            } else {
                Trie t = chars[s.charAt(i) - 'a'];
                if (t == null)
                    t = new Trie();
                chars[s.charAt(i) - 'a'] = t;
                return t.insertOrInc(s, i+1);
            }
        }
    }
}
