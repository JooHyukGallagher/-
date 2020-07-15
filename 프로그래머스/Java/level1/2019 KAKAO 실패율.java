class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        double[] st = new double[N + 1];
        st[0] = -1;
        boolean[] check = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            double curStageNum = 0;
            double curStageNotClearNum = 0;
            for (int j = 0; j < stages.length; j++) {
                if (i < stages[j]) {
                    curStageNum++;
                } else if (i == stages[j]) {
                    curStageNum++;
                    curStageNotClearNum++;
                }
            }
            if (curStageNotClearNum == 0) {
                st[i] = 0;
            } else {
                st[i] = curStageNotClearNum / curStageNum;
            }
        }

        for (int i = 1; i <= N; i++) {
            int idx = 0;
                for (int j = 1; j <= N; j++) {
                    if (!check[j] && st[idx] < st[j]) {
                        idx = j;
                    }
                }
                answer[i - 1] = idx;
                check[idx] = true;
        }
        return answer;

    }
    
}