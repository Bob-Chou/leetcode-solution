class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int left = Math.max(A, E);
        int bottom = Math.max(B, F);
        int right = Math.min(C, G);
        int top = Math.min(D, H);

        int common = 0;
        if (left < right && bottom < top)
            common =  (right - left) * (top - bottom);
        return -common+(C-A)*(D-B)+(E-G)*(F-H);
    }
}
