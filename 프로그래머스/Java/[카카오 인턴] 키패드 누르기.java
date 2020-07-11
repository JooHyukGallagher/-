public class Pair {
    int row;
    int column;

    public Pair(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

class Solution {
    public boolean isLeft(Pair left, Pair right, Pair nextThumb, String hand) {
        int leftLength = Math.abs(nextThumb.column - left.column) + 
            Math.abs(nextThumb.row - left.row);
        int rightLength = Math.abs(nextThumb.column - right.column) + 
            Math.abs(nextThumb.row - right.row);

        if (leftLength < rightLength) {
            return true;
        } else if(leftLength > rightLength) {
            return false;
        } else {
            return !hand.equals("right");
        }
    }
    
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        Pair leftThumb = new Pair(3, 0);
        Pair rightThumb = new Pair(3, 2);

        for(int number : numbers) {
            if((number + 2) % 3 == 0) {
                sb.append("L");
                leftThumb = new Pair((number+2) / 3 - 1, 0);
            } else if((number+2) % 3 == 2 && number != 0) {
                sb.append("R");
                rightThumb = new Pair((number+2) / 3 - 1, 2);
            } else {
                Pair nextThumb = null;
                if(number == 0) {
                    nextThumb = new Pair(3, 1);
                } else {
                    nextThumb = new Pair((number+2) / 3 - 1, 1);
                }
                if(isLeft(leftThumb, rightThumb, nextThumb, hand)) {
                    sb.append("L");
                    leftThumb = nextThumb;
                } else {
                    sb.append("R");
                    rightThumb = nextThumb;
                }
            }
        }

        answer = sb.toString();
        return answer;

    }
     
}