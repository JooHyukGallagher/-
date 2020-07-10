class Solution {
    public int majorityElement(int[] nums) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int n : nums) {
            if(map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }
        
        Iterator<Integer> iterator = map.keySet().iterator();
        while(iterator.hasNext()) {
            int key = iterator.next();
            if(map.get(key) > nums.length/2) {
                answer = key;
                break;
            }
        }
        
        
        return answer;
    }
}