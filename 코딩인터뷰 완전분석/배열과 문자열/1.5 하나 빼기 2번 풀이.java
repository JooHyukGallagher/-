
public class exam05_02 {
    static boolean oneEditAway(String first, String second) {
        // 길이 체크
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }

        // 길이가 짧은 문자열과 긴 문자열 찾기
        String str1 = first.length() < second.length() ? first : second;
        String str2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < str2.length() && index1 < str1.length()) {
            if (str1.charAt(index1) != str2.charAt(index2)) {
                // 반드시 첫 번째로 다른 문자여야 한다.
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
                if (str1.length() == str2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }
            index2++;
        }
        return true;
    }

    public static void main(String[] args) {
        String str1 = "pale";
        String str2 = "ple";
        System.out.println(oneEditAway(str1, str2));
    }
}
