class Solution {
    public int strStr(String haystack, String needle) {
        int answer = -1;
        int haystackLength = haystack.length();
        int needleLength = needle.length();
        
        boolean flag;
        for(int i=0; i<haystackLength - needleLength + 1; i++) {
            String splitStr = haystack.substring(i, i+needleLength);
            flag = splitStr.equals(needle);
            if(flag) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}