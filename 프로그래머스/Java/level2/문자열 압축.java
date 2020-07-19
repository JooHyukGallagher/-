class Solution {
        public int getStrLength(String s, int splitLength) {
        int start = 0;
        int length = s.length();

        StringBuilder sb = new StringBuilder();
        StringBuilder splitBuilder = new StringBuilder();
        int strNum = 0;
        String prevStr = "";
        String curStr = "";
        while(length >= splitLength) {
            curStr = s.substring(start, start + splitLength);
            if(prevStr.equals(curStr)) {
                strNum++;
            } else {
                if(strNum > 1){
                    sb.append(strNum);
                }
                sb.append(splitBuilder);
                splitBuilder = new StringBuilder();
                splitBuilder.append(curStr);
                strNum = 1;
            }
            prevStr = curStr;
            start += splitLength;
            length -= splitLength;
        }

        if(strNum > 1){
            sb.append(strNum);
        }
        sb.append(splitBuilder);
        if(length > 0) {
            String substring = s.substring(start);
            sb.append(substring);
        }

        return sb.toString().length();
    }

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;

        for(int i=1; i<=s.length(); i++){
            int num = getStrLength(s, i);
            if(answer > num) {
                answer = num;
            }
        }
        return answer;
    }

}