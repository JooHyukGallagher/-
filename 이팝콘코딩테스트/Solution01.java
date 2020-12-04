package 이팝콘코딩테스트;

public class Solution01 {
    public static int reverse(int x) {
        char[] chars = String.valueOf(x).toCharArray();

        for(int i=0; i<chars.length/2; i++) {
           char temp = chars[i];
           chars[i] = chars[chars.length-1-i];
           chars[chars.length-1-i] = temp;
        }

        // 뒤집어진 문자열에서 마지막 0이 나오는 index
        int zeroIdx = 0;
        for (int i=0; i<chars.length; i++) {
            if (chars[i] != '0') {
                break;
            }
            zeroIdx = i;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (char aChar : chars) {
            stringBuilder.append(aChar);
        }

        String answer = stringBuilder.toString().substring(zeroIdx + 1);
        return Integer.parseInt(answer);
    }

    public static void main(String[] args) {
        System.out.println(reverse(1200));
    }

}
