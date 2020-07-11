class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
         String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            sb = new StringBuilder();
            String oneLine = Integer.toBinaryString(arr1[i] | arr2[i]);
            String numToSharp = oneLine.replace('1', '#');
            String result = numToSharp.replace('0', ' ');
            sb.append(" ".repeat(Math.max(0, n - oneLine.length())));
            sb.append(result);
            answer[i] = sb.toString();
        }

		return answer;
    }
}