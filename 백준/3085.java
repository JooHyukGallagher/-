import java.util.Scanner;

public class Main {
    static int ans;
    static char[][] map;
    static int n;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.nextLine();
        map = new char[n][n];
        for (int i = 0; i < n; i++) {
            map[i] = scanner.nextLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // 가로로 교환
                char temp = map[i][j];
                map[i][j] = map[i][j + 1];
                map[i][j + 1] = temp;
                check();
                temp = map[i][j];
                map[i][j] = map[i][j + 1];
                map[i][j + 1] = temp;

                // 세로로 교환
                temp = map[j][i];
                map[j][i] = map[j + 1][i];
                map[j + 1][i] = temp;
                check();
                temp = map[j][i];
                map[j][i] = map[j + 1][i];
                map[j + 1][i] = temp;
            }
        }
        System.out.println(ans);
    }

    private static void check() {
        // 가로 갯수
        for (int i = 0; i < n; i++) {
            int sum = 1;
            for (int j = 0; j < n - 1; j++) {
                if (map[i][j] == map[i][j + 1]) {
                    ++sum;
                } else {
                    ans = Math.max(ans, sum);
                    sum = 1;
                }
            }
            ans = Math.max(ans, sum);
        }
        // 세로 갯수
        for (int i = 0; i < n; i++) {
            int sum = 1;
            for (int j = 0; j < n - 1; j++) {
                if (map[j][i] == map[j + 1][i]) {
                    ++sum;
                } else {
                    ans = Math.max(ans, sum);
                    sum = 1;
                }
            }
            ans = Math.max(ans, sum);
        }
    }
}
