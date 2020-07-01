class Solution {
    public boolean isPalindrome(int x) {
       
        boolean answer = true;
        
        String palindrome = String.valueOf(x);
        char[] pc = palindrome.toCharArray();
        
        int length = pc.length;
        for(int i=0; i<length/2; i++) {
            if(pc[i] != pc[length-(i+1)]) {
                answer = false;
                break;
            }
        }
        
        
        return answer;
    }
}