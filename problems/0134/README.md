# Problem 134
## Review log
+ 08/14/2019 Fail to solve.

## Insight
It's pretty easy. I am absolutely an idiot. 
1. The start station should have extra gas.
2. If starting at m station cannot arrive n, starting at any station between m and n cannot arrive n as well (provided that m station can offer extra gas)
3. So the solution: set start = 0 and scan the array, update remain and total. When get remain < 0, reset start = i + 1. After scanning, if total > 0, then return start, else return -1.
