import java.util.Scanner;

public class Main {
    static int n;
    static int m;

    static char[][] map;
    static int[][] dist;
    static boolean[][] check;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};


    private static boolean dfs(int x, int y, int cnt) {
        if (check[x][y]) {
            return cnt - dist[x][y] >= 4;
        }

        check[x][y] = true;
        dist[x][y] = cnt;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                if (map[nx][ny] == map[x][y]) {
                    if(dfs(nx, ny, cnt + 1)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        map = new char[n][m];
        check = new boolean[n][m];
        dist = new int[n][m];
        scanner.nextLine();

        for (int i = 0; i < n; i++) {
            String text = scanner.nextLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = text.charAt(j);
            }
        }

        boolean ans = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!check[i][j]) {
                    boolean ok = dfs(i, j, 0);
                    if (ok) {
                        ans = true;
                    }
                }
            }
        }

        if (ans) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

}
