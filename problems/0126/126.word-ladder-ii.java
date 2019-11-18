class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> router = new HashMap<>();
        Map<String, List<String>> encoder = new HashMap<>();
        Map<String, List<String>> decoder = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (String word : wordList) {
            encoder.putIfAbsent(word, new LinkedList<>());
            List<String> codes = encoder.get(word);
            for (int i = 0; i < word.length(); ++i) {
                sb.setLength(0);
                for (int j = 0; j < word.length(); ++j) {
                    sb.append(i == j ? '.' : word.charAt(j));
                }
                String code = sb.toString();
                codes.add(code);
                decoder.putIfAbsent(code, new LinkedList<>());
                decoder.get(code).add(word);
            }
        }

        for (String word : wordList) {
            router.putIfAbsent(word, new LinkedList<>());
            List<String> adjacents = router.get(word);
            for (String code : encoder.get(word)) {
                for (String adjacent : decoder.get(code)) {
                    if (!adjacent.equals(word))
                        adjacents.add(adjacent);
                }
            }
        }

        if (!router.containsKey(beginWord)) {
            List<String> adjacents = new LinkedList<>();
            for (int i = 0; i < beginWord.length(); ++i) {
                sb.setLength(0);
                for (int j = 0; j < beginWord.length(); ++j) {
                    sb.append(i == j ? '.' : beginWord.charAt(j));
                }
                String code = sb.toString();
                if (decoder.containsKey(code)) {
                    adjacents.addAll(decoder.get(code));
                }
            }
            router.put(beginWord, adjacents);
        }

        List<List<String>> ans = new LinkedList<>();
        Queue<Node> path = new LinkedList<>();
        Node root = new Node(beginWord);
        Set<String> visited = new HashSet<>();
        path.offer(root);
        int reachStep = Integer.MAX_VALUE;

        while (!path.isEmpty()) {
            Node currNode = path.poll();
            visited.add(currNode.val);
            if (currNode.step > reachStep)
                break;
            if (currNode.val.equals(endWord)) {
                reachStep = currNode.step;
                Node p = currNode;
                List<String> ladder = new LinkedList<>();
                while (p != null) {
                    ladder.add(0, p.val);
                    p = p.parent;
                }
                ans.add(ladder);
            } else if (reachStep == currNode.step) {
                continue;
            }

            for (String next : router.get(currNode.val)) {
                if (next.equals(endWord) || !visited.contains(next)) {
                    Node nextNode = new Node(next, currNode);
                    path.offer(nextNode);
                }
            }
        }

        return ans;
    }

    class Node {
        public Node(String s) {
            val = s;
        }
        public Node(String s, Node p) {
            val = s;
            parent = p;
            step = p.step + 1;
        }
        public Node parent = null;
        public String val = null;
        public int step = 0;
        public List<Node> children = new LinkedList<>();
    }
}
