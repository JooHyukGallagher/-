import java.util.Stack;

class Solution {
    static String solution(String p) {
        if (p.equals("")) {
            return "";
        }

        int divideIdx = divideStr(p);
        String u = p.substring(0, divideIdx);
        String v = p.substring(divideIdx);

        if (isRightStr(u)) {
            return u + solution(v);
        } else {
            String temp = '(' + solution(v) + ')';
            u = u.substring(1, u.length() - 1);
            u = reverse(u);
            return temp + u;
        }
    }

    private static String reverse(String u) {
        StringBuilder reverseStr = new StringBuilder();
        for (int i = 0; i < u.length(); i++) {
            if (u.charAt(i) == ')') {
                reverseStr.append('(');
            } else {
                reverseStr.append(')');
            }
        }
        return reverseStr.toString();
    }

    static int divideStr(String p) {
        int startNum = 0;
        int endNum = 0;

        char[] bracket = p.toCharArray();
        int i;
        for (i = 0; i < bracket.length; i++) {
            if (bracket[i] == '(') {
                startNum++;
            } else if (bracket[i] == ')') {
                endNum++;
            }
            if (startNum == endNum) {
                return i + 1;
            }
        }

        return i;
    }

    static boolean isRightStr(String str) {
        char[] bracket = str.toCharArray();
        if (bracket[0] != '(') return false;

        Stack<Character> stack = new Stack<>();
        for (char c : bracket) {
            if (c == '(') {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}