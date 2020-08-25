import java.util.Scanner;

public class exam02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        int[] arr = new int[m+1];
        for (int i=0; i<n; i++) {
            int num = scanner.nextInt();
            arr[num]++;
        }

        int answer = 0;
        for (int i=1; i<=m; i++) {
            n -= arr[i];
            answer += (arr[i] * n);
        }

        System.out.println(answer);
    }
}
