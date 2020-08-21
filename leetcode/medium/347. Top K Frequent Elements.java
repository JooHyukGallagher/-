class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] answer = {};

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int x : nums) {
            if (map.containsKey(x)) {
                Integer value = map.get(x);
                map.put(x, value+1);
            } else {
                map.put(x, 1);
            }
        }

        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        while(k-- > 0) {
            int maxValue = 0;
            int maxKey = 0;
            for(int key : map.keySet()) {
                if (maxValue < map.get(key)) {
                    maxValue = map.get(key);
                    maxKey = key;
                }
            }
            arrayList.add(maxKey);
            map.remove(maxKey);
        }

        answer = new int[arrayList.size()];
        for(int i=0; i<answer.length; i++) {
            answer[i] = arrayList.get(i);
        }

        Arrays.sort(answer);
        return answer;

    }
}