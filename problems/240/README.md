# Problem 240
## Review log
+ 04/25/2019 Fail to reach the optimum solution.

## Insight
### two pointers
Search from the most bottom-right corner, if the number is greater than the target, then `--col`, else `++row`. This solution is faster.

### Divide-and-Conquer
Compare the target with the center element of a matrix, then the rest of the matrix can be seen as top-left top-right bottom-left bottom-right 4 parts.
If the center element is bigger than the target, then we cannot find the result in the top-left area, we keep looking for it in the other 3 parts.
If the center element is smaller than the target, then we cannot find the result in the bottom-right area, we look for it in the other 3 parts.
```java
public boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
        return false;
    }
    return searchMatrix(matrix, target, 0, matrix.length - 1, 0, matrix[0].length - 1);
}

private boolean searchMatrix(int[][] matrix, int target, int rowStart, int rowEnd, int colStart, int colEnd) {
    if (rowStart > rowEnd || colStart > colEnd) {
        return false;
    }
    if (rowStart == rowEnd && colStart == colEnd) {
        return target == matrix[rowStart][colStart];
    }
    int midRow = rowStart + (rowEnd - rowStart) / 2;
    int midCol = colStart + (colEnd - colStart) / 2;
    if (matrix[midRow][midCol] == target) {
        return true;
    }
    else if (matrix[midRow][midCol] > target) {
        return searchMatrix(matrix, target, rowStart, midRow - 1, colStart, colEnd) || searchMatrix(matrix, target, midRow, rowEnd, colStart, midCol - 1);
    }
    else {
        return searchMatrix(matrix, target, rowStart, midRow, midCol + 1, colEnd) || searchMatrix(matrix, target, midRow + 1, rowEnd, colStart, colEnd);
    }
}
```
