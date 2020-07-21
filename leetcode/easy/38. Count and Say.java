class Solution {
    public String countAndSay(int n) {
        StringBuilder currStr = new StringBuilder("1");
        StringBuilder prevStr;
        int strCnt = 0;
        char num;
        for(int i=1; i<n; i++) {
            prevStr = currStr;
            currStr = new StringBuilder();
            strCnt = 1;
            num = prevStr.charAt(0);
            for(int j=1, len=prevStr.length(); j<len; j++) {
                if(prevStr.charAt(j) != num) {
                    currStr.append(strCnt).append(num);
                    strCnt = 1;
                    num = prevStr.charAt(j);
                } else {
                    strCnt++;
                }
            }
            currStr.append(strCnt).append(num);
        }
        return currStr.toString();
    }
}