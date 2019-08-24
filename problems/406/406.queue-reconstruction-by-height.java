class Solution {
    public int[][] reconstructQueue(int[][] p) {
        Arrays.sort(p, (a, b)->a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(b[0], a[0]));
        for(int i = 1; i < p.length; i++) {
            int idx = p[i][1];
            int[] t = p[i];
            for(int j = i-1; j >= idx; j--) p[j+1] = p[j];
            p[idx] = t;
        }
        return p;
    }
}
