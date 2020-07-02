class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0) {
            return false;
        }
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if(stack.size() == 0){
                return false;
            } else if(c == ')') {
               if(stack.peek() == '('){
                   stack.pop();
               } 
            } else if(c == '}') {
               if(stack.peek() == '{'){
                   stack.pop();
               } 
            } else if(c == ']') {
               if(stack.peek() == '['){
                   stack.pop();
               } 
            }
        }
        
        if(stack.size() == 0) {
            return true;
        } else {
            return false;
        }
    }
}