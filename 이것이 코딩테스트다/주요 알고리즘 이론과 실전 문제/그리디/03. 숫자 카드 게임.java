import java.util.Scanner;

public class exam02 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] map = new int[n][m];
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                map[i][j] = scanner.nextInt();
            }
            int minNum = 10000;
            for (int j=0; j<m; j++) {
                if (minNum > map[i][j]) {
                    minNum = map[i][j];
                }
            }
            if (answer < minNum) {
                answer = minNum;
            }
        }

        System.out.println(answer);
    }
}
