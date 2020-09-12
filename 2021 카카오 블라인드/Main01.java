public class Main01 {
    static String lower(String new_id) {
        StringBuilder sb = new StringBuilder();
        for (char c : new_id.toCharArray()) {
            if ('A' <= c && c <= 'Z') {
                sb.append((char) (c + 32));
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String removeSpecialCharacters(String new_id) {
        StringBuilder sb = new StringBuilder();
        for (char c : new_id.toCharArray()) {
            if (('0' <= c && c <= '9') || ('a' <= c && c <= 'z') || c == '-' || c == '_' || c == '.') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    static String removeContinuousDots(String new_id) {
        StringBuilder sb = new StringBuilder();
        char[] c = new_id.toCharArray();
        sb.append(c[0]);
        for (int i = 1; i < c.length; i++) {
            if (c[i] == '.' && c[i - 1] == '.') {
                continue;
            } else {
                sb.append(c[i]);
            }
        }
        return sb.toString();
    }

    static String removeFirstEndDots(String new_id) {
        if (new_id.charAt(0) == '.') {
            if (new_id.length() == 1) {
                return "";
            }
            new_id = new_id.substring(1);
        }
        if (new_id.charAt(new_id.length() - 1) == '.') {
            if (new_id.length() == 1) {
                return "";
            }
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        return new_id;
    }

    static String addA(String new_id) {
        if (new_id.equals("")) {
            return "a";
        }
        return new_id;
    }

    static String subStr(String new_id) {
        int length = new_id.length();
        if (length >= 16) {
            new_id = new_id.substring(0, 15);
        }
        if (new_id.charAt(new_id.length() - 1) == '.') {
            new_id = new_id.substring(0, new_id.length() - 1);
        }
        return new_id;
    }

    static String moreChar(String new_id) {
        StringBuilder sb = new StringBuilder();
        if (new_id.length() == 1) {
            sb.append(new_id.charAt(0));
            sb.append(new_id.charAt(0));
            sb.append(new_id.charAt(0));
            return sb.toString();
        } else if (new_id.length() == 2) {
            sb.append(new_id.charAt(0));
            sb.append(new_id.charAt(1));
            sb.append(new_id.charAt(1));
            return sb.toString();
        }
        return new_id;
    }

    public static String solution(String new_id) {
        String answer = "";

        answer = lower(new_id);
        answer = removeSpecialCharacters(answer);
        answer = removeContinuousDots(answer);
        answer = removeFirstEndDots(answer);
        answer = addA(answer);
        answer = subStr(answer);
        answer = moreChar(answer);

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
        System.out.println(solution("z-+.^."));
        System.out.println(solution("=.="));
        System.out.println(solution("123_.def"));
        System.out.println(solution("abcdefghijklmn.p"));
    }

}