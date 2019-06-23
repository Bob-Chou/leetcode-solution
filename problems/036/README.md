# Problem 11
## Review log
+ 06/22/2019 AC

## Insight
My solution is to use prime number mutiplication. A better solution is to use bit manipulation: use a nine-digit binary number (each digit is assigned to one number) to record the existance of the number in each row/column/subbox.
```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
            // write your code here.
        int[] row = new int[9];
        int[] col = new int[9];
        int[][] sub = new int[3][3];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int val = 0;
                if (board[i][j] == '.') {
                    continue;
                } else {
                    val = board[i][j] - '0';
                }
                if ((row[i] & (1 << val)) != 0) {
                    return false;
                } else {
                    row[i] |= (1 << val);
                }

                if ((col[j] & (1 << val)) != 0) {
                    return false;
                } else {
                    col[j] |= (1 << val);
                }

                if ((sub[i / 3][j / 3] & (1 << val)) != 0) {
                    return false;
                } else {
                    sub[i / 3][j / 3] |= (1 << val);
                }
            }
        }
        return true;
    }
}

```
