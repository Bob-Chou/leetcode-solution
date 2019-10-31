# Problem 56
## Review log
+ 04/02/2019 AC. I don't know how to customize a sorting function in Java so I write a quick-sort manually.

## Insight
If the input array is sorted by the start value, then we can record the left boundary and right boundary ofcurrent interval and iterate the invervals to update two boundarys. When we get a interval whose start is larger than our current right boundary, we know that this interval wouldn't overlap previous intervals, then we add a merged interval based on current boundaries, and move on to a new interval. Repeat above steps until we get all the input interval.

However, the input array might in any order, so we need sort the input array to ensure the interval array is ordered by start point.

```java
// This built-in method would be slower than manual quick sort
Collections.sort(vals, (a, b) -> a.start - b.start);
```

