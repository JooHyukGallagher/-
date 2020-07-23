class Solution {
    public int[] plusOne(int[] digits) {
        int digitLength = digits.length;
        
        digits[digitLength-1] += 1;
        for(int i = digitLength-1; i>=1; i--) {
            if(digits[i] >= 10) {
                digits[i] = 0;
                digits[i-1] += 1;
            }
        }
        
        int[] answer;
        if(digits[0] >= 10) {
            answer = new int[digitLength+1];
            answer[0] = 1;
            answer[1] = 0;
            for(int i=2; i<answer.length; i++) {
                answer[i] = digits[i-1];
            }
        } else {
            answer = digits;
        }

        return answer;
    }
    
}