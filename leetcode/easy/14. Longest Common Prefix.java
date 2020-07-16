class Solution {
    public String longestCommonPrefix(String[] strs) {
        String answer = "";
        
        if(strs.length == 0){
            return answer;
        }
        
        Arrays.sort(strs);
        
        StringBuilder sb = new StringBuilder();
        
        boolean flag = true;
        for(int i=0; i<strs[0].length(); i++) { // 몇번째 문자
            for(int j=0; j<strs.length-1; j++) {
                if(strs[j].charAt(i) != strs[j+1].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                sb.append(strs[0].charAt(i));
            } else {
                break;
            }
            
        }
        
        
        answer = sb.toString();
        return answer;
    }
}