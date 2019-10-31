# Problem 992
## Review log
+ 10/31/2019 Fail to resolve it. I tried hard to solve by one slide window. I didn't come up with two slide windows to record the furthest and nearest left boundary of valid subarray at `A[i]`.

## Insight
Using `MultiSet` to record distinct characters number. At each point `A[i]`, keep two `MultiSet`'s from `A[left1]` or `A[left2]` to `A[i]` to record the first point `left1` to meet requirement and the first point `left2` to unmeet. The add `left2 - left1` to answer. At each step, expand `MultiSet` rightwards at `A[i]` and shrinks leftwards to meet requirement.
