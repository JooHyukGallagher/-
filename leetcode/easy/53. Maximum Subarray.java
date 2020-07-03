class Solution {
    public int maxSubArray(int[] nums) {
        int[] max = new int[nums.length];
        
        max[0] = nums[0];
        for(int i=1; i<nums.length; i++) {
            if(max[i-1] + nums[i] > nums[i]) {
               max[i] = max[i-1] + nums[i];
            } else {
                max[i] = nums[i];
            }
        }
        
        int answer = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++) {
            if(answer < max[i]) {
                answer = max[i];
            }
        }
        
        return answer;
    }
}