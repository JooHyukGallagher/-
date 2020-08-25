import java.util.Arrays;
import java.util.Scanner;

public class exam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int oneSectionNum = 0;
        int zeroSectionNum = 0;
        char[] num = number.toCharArray();

        if (num[0] == '0') {
            zeroSectionNum++;
        } else if(num[0] == '1') {
            oneSectionNum++;
        }
        for (int i = 1; i < num.length; i++) {
            if (num[i-1] != num[i]) {
                if (num[i] == '1') {
                    oneSectionNum++;
                } else {
                    zeroSectionNum++;
                }
            }
        }

        int answer = Math.min(oneSectionNum, zeroSectionNum);
        System.out.println(answer);
    }
}
