class Solution {
    public int romanToInt(String s) {
        int answer = 0;
        int[] roman = {1, 5, 10, 50, 100, 500, 1000};
        
        int length = s.length();
        
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()) {
            if(c == 'I') {
                sb.append("0");
            } else if(c == 'V') {
                sb.append("1"); 
            } else if(c == 'X') {
                sb.append("2");
            } else if(c == 'L') {
                sb.append("3");
            } else if(c == 'C') {
                sb.append("4");
            } else if(c == 'D') {
                sb.append("5");
            } else if(c == 'M') {
                sb.append("6") ;
            }
        }
        
        String trans = sb.toString();
        int idx = length-1;
        while(idx > 0) {
            int romanIdx1 = trans.charAt(idx) - '0';
            int romanIdx2 = trans.charAt(idx-1) - '0';
            if(romanIdx1 > romanIdx2) {
                answer += roman[romanIdx1] - roman[romanIdx2];
                idx -= 2;
            } else {
                answer += roman[romanIdx1];
                idx -= 1;
            }
        }
        
        if(idx == 0){
            answer += roman[trans.charAt(idx)-'0'];
        }
        
        return answer;
        
    }
}