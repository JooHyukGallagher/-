import java.util.Stack;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        Stack<Integer> stack = new Stack<>();
        for(int column : moves) {
            for(int i=0; i<board.length; i++) {
                if(board[i][column-1] != 0) {
                    if(!stack.isEmpty() && stack.peek() == board[i][column-1]){
                        answer += 2;
                        stack.pop();
                    } else {
                    	stack.push(board[i][column-1]);
                    }
                    board[i][column-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }
}