class Solution {
    public int minimumCost(int N, int[][] connections) {
        UnionFind uf = new UnionFind(N);
        Arrays.sort(connections, (a, b) -> return a[2] - b[2]);
        int cost = 0;
        for (int i = 0; i < connections.length; ++i) {
            if (uf.find(connections[i][0]-1, connections[i][1]-1)){
                continue;
            } else {
                uf.union(connections[i][0]-1, connections[i][1]-1)
                cost += connections[i][2];
            }
        }
        if (uf.size() > 1)
            return -1;
        return cost;
    }

    class UnionFind {
        int[] ids;
        int[] counts;
        int distincts;

        public UnionFind(int n) {
            ids = new int[n];
            counts = new int[n];
            distincts = n;
            for (int i = 0; i < n; ++i) {
                ids[i] = i;
                counts[i] = 1;
            }
        }

        public void union(int id1, int id2) {
            id1 = getId(id1);
            id2 = getId(id2);
            if (id1 == id2)
                return;
            distincts -= 1;
            if (counts[id1] < counts[id2]) {
                counts[id2] += counts[id1];
                ids[id1] = id2;
            } else {
                counts[id1] += counts[id2];
                ids[id2] = id1;
            }
        }

        public int getId(int id) {
            while (id != ids[id]) {
                ids[id] = ids[ids[id]];
                id = ids[id];
            }
            return id;
        }

        public boolean find(int id1, int id2) {
            return getId(id1) == getId(id2);
        }

        public int size() {
            return distincts;
        }
    }
}
