# Problem 139
## Review log
+ 04/14/2019 Use straightforward string comparison method.

## Insight
The code could be further optimize by using trie.
```java
/**
 * For current idx i, we search s[j:i] for j <= i : if set contains the 
 * substring, then dp[i] = dp[j], else we make j--.
 *
 * So instead search the word for every j, we can put the word (reverse) 
 * into a trie, when j--, we just search the next level in the Trie tree.
 */
class Node {
        Node[] children;
        boolean isWord;
        public Node() {
            children = new Node[26];
            isWord = false;
        }
    }
    
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0)
            return false;

        int n = s.length();
        Node root = new Node;
        for (String w: wordDict) {
            // add reverse word, because we search word from end
            addWordReverse(w, root);
        }
        
        boolean[] dp = new boolean[n];

        for (int i = 0; i < n; i++) {
            Node cur = root;
            for (int j = i; j >= 0; j--) {
                char ch = s.charAt(j);
                // reuse Trie node, don't need search from root for every word
                cur = search(ch, cur);
                if (cur == null) {
                    // can't find valid word
                    break;
                }
                if (cur.isWord && (j == 0 || dp[j - 1])) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[n - 1];
    }
    
    private void addWordReverse(String word, Node root) {
        Node n = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char ch = word.charAt(i);
            int idx = ch - 'a';
            if (n.children[idx] == null) {
                n.children[idx] = new Node();
            }
            n = n.children[idx];
        }
        n.isWord = true;
    }
    
    private Node search(char ch, Node root) {
        if (root == null) {
            return null;
        }
        int idx = ch - 'a';
        return root.children[idx];
    }
```
