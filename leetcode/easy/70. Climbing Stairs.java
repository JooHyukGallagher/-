class Solution {
    public int climbStairs(int n) {
        int[] d = new int[n+1];
        
        for(int i=1; i<=n; i++){
            if(i <= 2) {
                d[i] = i;
            } else {
                d[i] = d[i-1] + d[i-2];
            }
        }
        
        return d[n];
    }
}