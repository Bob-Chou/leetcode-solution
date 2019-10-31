# Problem 11
## Review log
+ 04/02/2019 AC but time complexity is large. Used brute method.

## Insight
The simplest approach requires N sorting process, which is time consuming. Hence one way to improve the algorithm is to avoid sorting process, which means we need to design a special hash function.

### Hash Function 1
Notice that the total number of character is fixed, so a possible hash function might be counting the presence of each character in the string. In java, we can combine the counting number by special mark like '#'. In such case, the hash code of "abbc" and "cbba" should both be: "1#2#1#0#0...#0". If we adopt this hash function, we can avoid the sorting and reduce the time to get hashcode from O(NlogN) to O(N).

### Hash Function 2
A geniune but tricky approach is to define a hash function ensuring same anagrams to get the same unique hashcode. The pipeline of this function is:
1. mapping each character to a prime.
2. the hash code is the product of all the character in the string.
3. we know that the product of different prime set is different, so this hash function is meet our demand of solving this problem.

### Prime Solution
```java
public static List<List<String>> groupAnagrams(String[] strs) { 
   int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};//最多10609个z
    
    List<List<String>> res = new ArrayList<>();
    HashMap<Integer, Integer> map = new HashMap<>();
    for (String s : strs) {
        int key = 1;
        for (char c : s.toCharArray()) {
            key *= prime[c - 'a'];
        }
        List<String> t;
        if (map.containsKey(key)) {
            t = res.get(map.get(key));
        } else {
            t = new ArrayList<>();
            res.add(t);
            map.put(key, res.size() - 1);
        }
        t.add(s);
    }
    return res;
}
```
