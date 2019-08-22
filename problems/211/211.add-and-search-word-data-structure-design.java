class WordDictionary {
    private WordDictionary[] leafs;
    private boolean end;
    /** Initialize your data structure here. */
    public WordDictionary() {
        leafs = new WordDictionary[26];
        end = false;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        addWordHelper(word, 0);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchHelper(word, 0);
    }

    private void addWordHelper(String word, int i) {
        if (i == word.length())
            end = true;

        if (i >= word.length())
            return;

        int index = word.charAt(i) - 'a';
        if (leafs[index] == null)
            leafs[index] = new WordDictionary();
        leafs[index].addWordHelper(word, i+1);
    }

    private boolean searchHelper(String word, int i) {
        if (i == word.length())
            return end;
        if (i > word.length())
            return false;
        char c = word.charAt(i);
        boolean ans = false;
        if (c == '.') {
            for (int j = 0; j < 26 && !ans; ++j)
                ans |= leafs[j] != null && leafs[j].searchHelper(word, i+1);
        } else {
            int index = c - 'a';
            ans = leafs[index] != null && leafs[index].searchHelper(word, i+1);
        }
        return ans;
    }
}
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
