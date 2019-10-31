# Problem 11
## Review log
+ 04/02/2019 AC.

## Insight
Solution 1 (easier to program, with more steps):
+ flip the matrix by the horizontal symmetry axis
+ flip the matrix by the diagonal axis

Solution 2 (less steps):
+ from outer to inner, select the most upper-left (n-1) points and rotate to the next side, them do it again until all four sides are rotated
