class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int idx1 = 0;
        int idx2 = 0;
        
        for(int i=0; i<nums.length; i++) {
            idx1 = i;
            for(int j=i+1; j<nums.length; j++) {
                idx2 = j;
                if(nums[idx1] + nums[idx2] == target) {
                    break;
                }
            }
            if(nums[idx1] + nums[idx2] == target) {
                break;
            }
        }
        
        int[] answer = new int[]{idx1, idx2};
        return answer;
    }
}