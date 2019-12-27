class Solution {
    public String alienOrder(String[] words) {
        if (words == null || words.length == 0)
            return "";
        if (words.length == 1)
            return words[0];

        int[] prevs = new int[26];
        Arrays.fill(prevs, -1);
        List<Integer>[] posts = new LinkedList[26];
        Queue<Integer> topo = new LinkedList<>();
        for (int i = 1; i < words.length; ++i) {
            String parent = words[i-1];
            String child = words[i];
            int j = 0;
            for (; j < parent.length() && j < child.length(); ++j) {
                int p = parent.charAt(j) - 'a';
                int c = child.charAt(j) - 'a';
                if (prevs[p] < 0)
                    prevs[p] = 0;
                if (prevs[c] < 0)
                    prevs[c] = 0;
                if (p != c) {
                    // add edge from parent.charAt(j) to child.charAt(j);
                    ++prevs[c];
                    if (posts[p] == null) {
                        posts[p] = new LinkedList<>();
                    }
                    posts[p].add(c);
                    break;
                }
            }
            for (int k = j; k < parent.length(); ++k) {
                int p = parent.charAt(k) - 'a';
                if (prevs[p] < 0)
                    prevs[p] = 0;
            }
            for (int k = j; k < child.length(); ++k) {
                int c = child.charAt(k) - 'a';
                if (prevs[c] < 0)
                    prevs[c] = 0;
            }
        }
        int vocabCount = 0;
        for (int i = 0; i < prevs.length; ++i) {
            if (prevs[i] == 0) {
                topo.offer(i);
            }
            if (prevs[i] >= 0)
                ++vocabCount;
        }
        StringBuilder sb = new StringBuilder();
        while (!topo.isEmpty()) {
            int cur = topo.poll();
            sb.append((char)(cur + 'a'));
            if (posts[cur] != null) {
                for (int post : posts[cur]) {
                    if (--prevs[post] == 0)
                        topo.offer(post);
                }
            }
        }
        if (sb.length() < vocabCount)
            return "";
        return sb.toString();
    }
}
