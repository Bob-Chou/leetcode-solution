 # Problem 253
## Review log
+ 10/14/2019 AC.

## Insight
```java
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int i=0; i< intervals.length; i++)  {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        //將開始時間與結束時間排序
        Arrays.sort(starts);
        Arrays.sort(ends);
        int count = 0;
        int endIndex = 0;
        //若發現有開始時間早於結束時間，代表時間衝突，必須另開會議室，否則就遞增指標檢查下一個結束時間是否會發生衝突
        for (int i=0; i< intervals.length; i++)  {
            if (starts[i] < ends[endIndex])
                count++;
            else
                endIndex++;
        }
        
        return count;
        
    }
}
```
