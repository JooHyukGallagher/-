class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
             return 0;
        }
        int pivot = nums[0];
        int idx = 0;
        for(int i=1; i<nums.length; i++) {
            if(pivot != nums[i]) {
                idx++;
                nums[idx] = nums[i];
                pivot = nums[i];
            }
        }
        
        return idx+1;
    }
}