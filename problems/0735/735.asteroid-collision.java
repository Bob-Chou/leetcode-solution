class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        if (asteroids.length < 2)
            return asteroids;

        int[] rightwards = new int[asteroids.length];
        int[] ans = new int[asteroids.length];
        int top = -1;
        int p = 0;
        for (int n: asteroids) {
            if (n > 0) {
                rightwards[++top] = n;
            } else {
                for (; top >= 0; --top) {
                    if (rightwards[top] == -n) {
                        --top;
                        n = 0;
                        break;
                    } else if (rightwards[top] > -n) {
                        break;
                    }
                }
                if (top < 0 && n < 0) {
                    ans[p++] = n;
                }
            }
        }

        for (int i = 0; i <= top; ++i)
            ans[p++] = rightwards[i];

        return Arrays.copyOfRange(ans, 0, p);
    }
}
