class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        int maxLength = 0;
        Trie root = new Trie();
        // add dictionary
        for (String word : wordDict) {
            if (word.length() == 0)
                continue;
            if (word.length() > maxLength)
                maxLength = word.length();
            Trie tr = root;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                int idx = c - 'a';
                if (tr.next[idx] == null)
                    tr.next[idx] = new Trie();
                tr = tr.next[idx];
            }
            tr.isWord = true;
        }

        boolean[] isPossible = new boolean[s.length()+1];
        isPossible[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; --i) {
            Trie tr = root;
            for (int j = i; j < i + maxLength && j < s.length(); ++j) {
                char c = s.charAt(j);
                int idx = c - 'a';
                if (tr.next[idx] == null)
                    break;
                tr = tr.next[idx];
                if (tr.isWord) {
                    isPossible[i] |= isPossible[j+1];
                }
                if (isPossible[i])
                    break;
            }
        }

        if (!isPossible[0])
            return new LinkedList<>();

        // solve using dp
        List<List<List<Character>>> helper = new ArrayList<>();
        for (int i = 0; i < s.length() + 1; ++i)
            helper.add(null);
        helper.set(s.length(), new LinkedList<>());
        helper.get(s.length()).add(new LinkedList<>());
        for (int i = s.length() - 1; i >= 0; --i) {
            Trie tr = root;
            List<List<Character>> cur = null;
            for (int j = i; j < i + maxLength && j < s.length(); ++j) {
                char c = s.charAt(j);
                int idx = c - 'a';
                if (tr.next[idx] == null)
                    break;
                tr = tr.next[idx];
                if (tr.isWord) {
                    if (helper.get(j+1) != null) {
                        for (List<Character> suffix : helper.get(j+1)) {
                            List<Character> curWord = new LinkedList<>();
                            for (int k = i; k <= j; ++k) {
                                curWord.add(s.charAt(k));
                            }
                            if (suffix.size() != 0)
                                curWord.add(' ');
                            curWord.addAll(suffix);
                            if (cur == null)
                                cur = new LinkedList<>();
                            cur.add(curWord);
                        }
                    }
                }
                helper.set(i, cur);
            }
        }

        // format answer
        List<String> rtn = new LinkedList<>();
        if (helper.get(0) == null)
            return rtn;
        StringBuilder sb = new StringBuilder();
        for (List<Character> ans : helper.get(0)) {
            sb.setLength(0);
            for (char c : ans)
                sb.append(c);
            rtn.add(sb.toString());
        }
        return rtn;
    }

    // List<List<Character>> wordBreakFrom(String s, int start, int maxLength, Trie dict) {
    //     List<List<Character>> ans = new LinkedList<>();
    //     if (start >= s.length()) {
    //         ans.add(new LinkedList<>());
    //         return ans;
    //     }
    //     Trie tr = dict;
    //     for (int i = start; i < maxLength + start && i < s.length(); ++i) {
    //         int idx = s.charAt(i) - 'a';
    //         if (tr.next[idx] == null)
    //             return ans;
    //         tr = tr.next[idx];
    //         if (tr.isWord) {
    //             List<List<Character>> tails = wordBreakFrom(s, i+1, maxLength, dict);
    //             for (List<Character> t : tails) {
    //                 // space between words
    //                 if (t.size() != 0)
    //                     t.add(0, ' ');
    //                 // add current word
    //                 for (int j = i; j >= start; --j)
    //                     t.add(0, s.charAt(j));
    //             }
    //             ans.addAll(tails);
    //         }
    //     }
    //     return ans;
    // }

    final class Trie {
        public Trie[] next = new Trie[26];
        public boolean isWord = false;
    }
}
