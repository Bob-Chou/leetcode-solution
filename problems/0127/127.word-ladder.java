class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> codeToWord = new HashMap<>();
        Map<String, Set<String>> wordToCode = new HashMap<>();
        int L = beginWord.length();
        wordList.add(beginWord);
        wordList.forEach(word -> {
            for (int i = 0; i < L; ++i) {
                String code = word.substring(0, i) + "*" + word.substring(i+1);
                Set<String> wordSet = codeToWord.getOrDefault(code, new HashSet<>());
                wordSet.add(word);
                codeToWord.put(code, wordSet);
                Set<String> codeSet = wordToCode.getOrDefault(word, new HashSet<>());
                codeSet.add(code);
                wordToCode.put(word, codeSet);
            }
        });

        /** add beginWord to queue
         * queue serving process:
         * 1. poll a word from fwQueue, if word in bwVisited, return
         * 2. forEach code, offer all unvisited words matching the code to fwQueue,
         *    and also add them to fwVistied set.
         * 3. poll a word from bwQueue, if word in fwVisited, return
         * 4. forEach code, offer all unvisited words matching the code to bwQueue,
         *    and also add them to bwVistied set.
         * 5. repeat 1-4 until either queue is empty.
         */

        Queue<String> forwards = new LinkedList<>();
        Queue<String> backwards = new LinkedList<>();
        Set<String> fwVisited = new HashSet<>();
        Set<String> bwVisited = new HashSet<>();

        forwards.offer(beginWord);
        forwards.offer(endWord);
        fwVisited.add(beginWord);
        bwVisited.add(beginWord);

        int fwDepth = 1, bwDepth = 1, fwNum = 1, bwNum = 1;

        while (!forwards.isEmpty() && !backwards.isEmpty()) {
            // forwarding BFS
            while (--fwNum >= 0) {
                String word = forwards.poll();
                for (String c : wordToCode.get(word)) {
                    System.out.println(c);
                    for (String w: codeToWord.get(c)) {
                        if (bwVisited.contains(w)){
                            return fwDepth + bwDepth;
                        } else if (!fwVisited.contains(w)) {
                            System.out.println("forward: " + w);

                            fwVisited.add(w);
                            forwards.offer(w);
                        }
                    }
                }
            }

            if (fwNum == 0) {
                ++bwDepth;
                fwNum = forwards.size();
            }

            // backwarding BFS
            while (--bwNum >= 0) {
                String word = backwards.poll();
                for (String c : wordToCode.get(word)) {
                    for (String w : codeToWord.get(c)) {
                        if (bwVisited.contains(w)){
                            return fwDepth + bwDepth;
                        } else if (!fwVisited.contains(w)) {
                            System.out.println("backward: " + w);
                            fwVisited.add(w);
                            backwards.offer(w);
                        }
                    }
                }
            }

            if (bwNum == 0) {
                ++bwDepth;
                bwNum = backwards.size();
            }
        }

        return 0;
    }
}
