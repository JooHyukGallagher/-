import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
                int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int x : scoville) {
            priorityQueue.add(x);
        }

        while (priorityQueue.peek() < K) {
            if (priorityQueue.size() == 1) {
                return -1;
            }

            int sco1 = priorityQueue.poll();
            int sco2 = priorityQueue.poll();

            priorityQueue.add(sco1 + sco2 * 2);

            answer++;
        }
        return answer;

    }
}