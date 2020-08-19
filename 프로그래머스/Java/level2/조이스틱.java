class Solution {
    public int solution(String name) {
        int answer = 0;
        int nameLength = name.length();

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < nameLength; i++) {
            stringBuilder.append("A");
        }
        String pivotStr = stringBuilder.toString();

        int[] num = new int[nameLength];
        boolean[] check = new boolean[nameLength];
        for (int i = 0; i < nameLength; i++) {
            num[i] = name.charAt(i) - pivotStr.charAt(i);
            if (num[i] == 0) {
                check[i] = true;
            }

            if (num[i] <= 12) {
                answer += num[i];
            } else {
                answer += (25 - num[i] + 1);
            }

        }

        int minMove = nameLength - 1;
        for (int i = 0; i < nameLength; i++) {
            if (name.charAt(i) != 'A') {
                int next = i + 1;
                while(next < nameLength && name.charAt(next) == 'A') {
                    next++;
                }
                int move = 2 * i + nameLength - next;
                 minMove = Math.min(move, minMove);
            }
        }

        answer += minMove;

        return answer;

    }
}