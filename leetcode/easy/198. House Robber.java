class Solution {
    public static int[] d = new int[101];
    
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if(nums.length == 1) {
            return nums[0];
        }
        
        d[0] = nums[0];
        d[1] = d[0] < nums[1] ? nums[1] : d[0];
        
        for(int i=2; i<nums.length; i++) {
            d[i] = Math.max(d[i-2] + nums[i], d[i-1]);
        }
        
        return d[nums.length-1];
    }
}