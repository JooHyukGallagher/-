class Solution {
    public long gcd(long a, long b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b, a%b);
        }
    }
    
    public long solution(int w, int h) {
        long answer = 1;
       
        long shorter = h;
        long longer = w;
        if(w < h) {
            shorter = w;
            longer = h;
        }
        
        long g = gcd(longer, shorter);
        answer = (longer*shorter) - (longer + shorter - g);
        return answer;
    }
}