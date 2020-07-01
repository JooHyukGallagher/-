class Solution {
    public void swap(char[] reverseNumber, int idx1, int idx2) {
        char temp;
        temp = reverseNumber[idx1];
        reverseNumber[idx1] = reverseNumber[idx2];
        reverseNumber[idx2] = temp;
    }
    
    public int reverse(int x) {
        boolean isMinus = false;
        String number = String.valueOf(x);
        
        char[] reverseNumber = {};
        
        if(number.charAt(0) == '-') {
            isMinus = true;
           reverseNumber = number.substring(1).toCharArray();
        } else {
           reverseNumber = number.toCharArray();
        }
        
        int length = reverseNumber.length;
        for(int i=0; i<length/2; i++){
           swap(reverseNumber, i, length-(i+1));
        }
        
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : reverseNumber) {
            stringBuilder.append(c);
        }
        
        String answerStr = stringBuilder.toString();
        if(isMinus) {
            answerStr = "-" + answerStr;
        }
        
        
        
        if(Long.parseLong(answerStr) > Integer.MAX_VALUE || Long.parseLong(answerStr) < Integer.MIN_VALUE) {
            return 0;
        } 
        
        return Integer.parseInt(answerStr);
    }
}