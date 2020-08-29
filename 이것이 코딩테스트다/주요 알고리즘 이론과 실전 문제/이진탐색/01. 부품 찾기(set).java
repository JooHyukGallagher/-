import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] part = new int[n];
        for (int i = 0; i < n; i++) {
            part[i] = scanner.nextInt();
        }
        scanner.nextLine();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[] req = new int[m];
        for (int i = 0; i < m; i++) {
            req[i] = scanner.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(part[i]);
        }

        for (int i = 0; i < m; i++) {
            if (set.contains(req[i])) {
                System.out.print("yes ");
            } else {
                System.out.print("no ");
            }
        }
    }
}
