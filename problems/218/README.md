# Problem 218
## Review log
+ 09/18/2019 Use sweep line. Fail to use binary divide-conquer

## Insight
### Divide-and-Conquer
If we have to skyline, we can merge it to one skyline. So we could divide this problem into smaller one: get the skyline of left buildings and the one of right buildings. Then we merge it into a new skyline. This process could be continuously divided into only one buildings. This process is like merge sorting.

The merge process could be:
1. let two pointer scan the left skyline array and the right one respectively.
2. if left one is closer (with smaller x coordinate), then update left height and increase left pointer.
3. if the maximum of left height and right height is equal to last building in new merged skyline array, then skip it. Or add the larger one into merged skyline array.
