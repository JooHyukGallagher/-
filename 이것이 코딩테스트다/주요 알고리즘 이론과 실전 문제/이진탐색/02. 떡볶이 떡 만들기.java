import java.util.Arrays;
import java.util.Scanner;

public class Main02 {
    static int sumCake(int start, int end, int cutLength, int[] cake) {
        int sum = 0;
        for (int i=start; i<=end; i++) {
            sum += (cake[i] - cutLength);
        }
        return sum;
    }

    static int binarySearch(int target, int start, int end, int[] cake) {
        while (start <= end) {
            int mid = (start + end) / 2;
            int cutLength = cake[mid];
            int sum = sumCake(mid+1, end, cutLength, cake);

            if (sum == target) {
                return cutLength;
            } else if (sum < target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[] cake = new int[n];
        for (int i = 0; i < n; i++) {
            cake[i] = scanner.nextInt();
        }

        Arrays.sort(cake);

        int answer = binarySearch(m, 0, n - 1, cake);
        System.out.println(answer);
    }
}
