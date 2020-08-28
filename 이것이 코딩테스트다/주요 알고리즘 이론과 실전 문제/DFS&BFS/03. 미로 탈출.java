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
    static int n;
    static int m;
    static int[][] map;

    static void bfs(int x, int y) {
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            x = p.x;
            y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < n && 0 <= ny && ny < m) {
                    if (map[nx][ny] == 1) {
                        map[nx][ny] = map[x][y] + 1;
                        queue.add(new Pair(nx, ny));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        map = new int[n][m];
        for (int i = 0; i < n; i++) {
            char[] command = scanner.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = command[j] - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[n-1][m-1]);
    }
}
