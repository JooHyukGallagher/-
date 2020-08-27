import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class exam01 {
    static class Pair {
        int x, y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    static void bfs(int x, int y, int[][] map, boolean[][] check, int n, int m) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        check[x][y] = true;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            x = p.x;
            y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] == 0 && !check[nx][ny]) {
                        queue.add(new Pair(nx, ny));
                        check[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        scanner.nextLine();
        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            String command = scanner.nextLine();
            char[] line = command.toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = line[j] - '0';
            }
        }

        int answer = 0;
        boolean[][] check = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0 && !check[i][j]) {
                    bfs(i, j, map, check, n, m);
                    answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
