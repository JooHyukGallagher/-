import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine();
        Integer[] a = new Integer[n];
        Integer[] b = new Integer[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());

        for (int i = 0; i < k; i++) {
            if (a[i] < b[i]){
                a[i] = b[i];
            } else {
                break;
            }
        }
        int sum = 0;
        for (int x : a) {
            sum += x;
        }
        System.out.println(sum);
    }
}
