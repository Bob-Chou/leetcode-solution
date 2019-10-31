# Problem 42
## Review log
+ 10/03/2019 Come up with stack solution

## Insight
Each position could trap a strip-like water with its height as bottom, maximum height of its left bars as left bar, and height of its right bars as right bar. For example, at position `p` of height `1`, the left bar height is `3` and right is `4`, so volumn of the strip-like water is `min(3, 4) - 1`
```text
            #
  #     o   #
  #     o   #
# #   # # # # 
-------------------
  ^     ^   ^
 l=3    p  r=4
```

Given this, the solution is straight forward. We could scan the heights at first and get `int[] leftBars` and `int[] rightBars` of each position. And scan for the second time, compute the total valumn by adding all the strip-like water with `volumn += min(leftBars[p], rightBars[p]) - heights[p];`. 

To improve this, we could also use two pointers. Initialize `left = 0, right = heights.length - 1;` and `leftBar = heights[0], leftBar = heights[heights.length - 1];`. Now use the pointer with lower height to scan, each time it reaches the new position, update the corresponding bar, or add to the `volumn` by `volumn += barCorrespondingToCurrentPointer - heights[currentPointer]`; If the updated bar is larger than the other, then switch to the other pointer and continue scanning until two pointers meet.
```text
Begin to move right pointer
      #   
      #   #
#     # # #
#   # # # #
-------------------
^         ^
l->       r

Switch to move right pointer
      #   
      #   #
# o o # # #
# o # # # #
-------------------
      ^   ^
      l <-r

Stop and return
      #   
      # o #
# o o # # #
# o # # # #
-------------------
      ^
     l=r
```
