class Solution {
     public boolean increasingTriplet(int[] nums) {
        int first=Integer.MAX_VALUE, second=first;
        for(int n: nums) {
            if(n > second)
                return true;
            else if(n <= first)
                first = n;
            else
                second = n;
        }
        return false;
    }
}
