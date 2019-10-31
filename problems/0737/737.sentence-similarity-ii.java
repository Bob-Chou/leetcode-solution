class Solution {
    final class StringId {
        private Map<String, Integer> stringToId = new HashMap<>();
        private int allocator = 0;
        public int encode(String s) {
            int id = allocator;
            if (stringToId.containsKey(s))
                id = stringToId.get(s);
            else
                stringToId.put(s, allocator++);
            return id;
        }
        public boolean contains(String s) {
            return stringToId.containsKey(s);
        }
    }
    final class UnionFind {
        private Map<Integer, Integer> ids = new HashMap<>();
        private Map<Integer, Integer> counts = new HashMap<>();
        private StringId converter = new StringId();
        public boolean contains(String s) {
            return converter.contains(s);
        }
        public boolean find(String s1, String s2) {
            if (!contains(s1) || !contains(s2))
                return false;
            int id1 = getRoot(converter.encode(s1));
            int id2 = getRoot(converter.encode(s2));
            return id1 == id2;
        }

        public void union(String s1, String s2) {
            int id1 = converter.encode(s1);
            int id2 = converter.encode(s2);
            if (ids.containsKey(id1)) {
                id1 = getRoot(id1);
            } else {
                ids.put(id1, id1);
                counts.put(id1, 1);
            }

            if (ids.containsKey(id2)) {
                id2 = getRoot(id2);
            } else {
                ids.put(id2, id2);
                counts.put(id2, 1);
            }

            if (id1 == id2)
                return;
            int cnt1 = counts.get(id1);
            int cnt2 = counts.get(id2);
            if (cnt1 < cnt2) {
                counts.put(id2, cnt1 + cnt2);
                ids.put(id1, id2);
            } else {
                counts.put(id1, cnt1 + cnt2);
                ids.put(id2, id1);
            }
        }

        private int getRoot(int id) {
            while (id != ids.get(id)) {
                ids.put(id, ids.get(ids.get(id)));
                id = ids.get(id);
            }
            return id;
        }
    }
    public boolean areSentencesSimilarTwo(String[] words1, String[] words2, List<List<String>> pairs) {
        if (words1.length != words2.length)
            return false;
        if (words1.length == 0 && words2.length == 0)
            return true;
        UnionFind helper = new UnionFind();
        pairs.forEach(p -> helper.union(p.get(0), p.get(1)));
        for (int i = 0; i < words1.length; ++i) {
            if (!words1[i].equals(words2[i]) &&
                (!helper.contains(words1[i]) ||
                 !helper.contains(words2[i]) ||
                 !helper.find(words1[i], words2[i])))
                return false;
        }
        return true;
    }
}
