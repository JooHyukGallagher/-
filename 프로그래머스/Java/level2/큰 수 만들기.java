class Solution {
    public String solution(String number, int k) {
                StringBuilder stringBuilder = new StringBuilder();

        int strLength = number.length();
        int strNum = strLength-k;
        int max = -1;
        int idx = 0;
        int left = 0;
        int right = number.length() - strNum;
        while(strNum > 0) {
            max = -1;
            for(int i=left; i<=right; i++) {
                int num = number.charAt(i) - '0';
                if(max < num) {
                    max = num;
                    idx = i;
                }
            }
            stringBuilder.append(number.charAt(idx));
            left = idx + 1;
            strNum--;
            right = number.length() - strNum;
        }

        return stringBuilder.toString();

    }
}