import java.util.Arrays;
import java.util.Scanner;

public class exam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        Arrays.sort(data);

        int target = 1;
        for (int coin : data) {
            if (target < coin) {
                break;
            }
            target += coin;
        }

        System.out.println(target);
    }
}
