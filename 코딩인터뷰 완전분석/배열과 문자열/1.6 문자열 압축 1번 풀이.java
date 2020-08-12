public class exam06_01 {
    static String compressBad(String str) {
        StringBuilder compressedString = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;
            // 다음 문자와 현재 문자가 같이 않다면 현재 문자를 결과 문자열에 추가해준다.
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressedString.append(str.charAt(i)).append(countConsecutive);
                countConsecutive = 0;
            }
        }

        return compressedString.length() < str.length() ? compressedString.toString() : str;
    }

    public static void main(String[] args) {
        String str = "aabcccccaaa";
        System.out.println(compressBad(str));
    }
}
