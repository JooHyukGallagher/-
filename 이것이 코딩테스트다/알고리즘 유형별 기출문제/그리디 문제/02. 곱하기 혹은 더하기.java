import java.util.Arrays;
import java.util.Scanner;

public class exam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        int[] num = new int[number.length()];
        char[] c = number.toCharArray();
        for (int i = 0; i < c.length; i++) {
            num[i] = c[i] - '0';
        }

        Arrays.sort(num);

        int answer = num[0];
        for (int i = 1; i < num.length; i++) {
            if (answer == 0 || answer == 1) {
                answer += num[i];
            } else {
                answer *= num[i];
            }
        }
        System.out.println(answer);
    }
}
