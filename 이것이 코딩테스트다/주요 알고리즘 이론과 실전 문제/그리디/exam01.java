
import java.util.Scanner;

public class exam01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();

        int coinNum = 0;

        int[] coin = {500, 100, 50, 10};
        for (int c : coin) {
            coinNum += n / c;
            n %= c;
        }

        System.out.println(coinNum);
    }
}
