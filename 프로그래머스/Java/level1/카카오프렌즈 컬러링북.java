import java.util.LinkedList;
import java.util.Queue;

class Solution {
    class Pair {
        int row;
        int column;

        Pair(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }

    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, 1, 0, -1 };

    static boolean[][] check = new boolean[1][1];
    static int max = 0;

    public void bfs(int x, int y, int m, int n, int stage, int[][] picture) {
        int stageArea = 0;

        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(x, y));
        check[x][y] = true;
        stageArea++;

        while (!queue.isEmpty()) {
            Pair p = queue.poll();
            x = p.row;
            y = p.column;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (0 <= nx && nx < m && 0 <= ny && ny < n) {
                    if (!check[nx][ny] && picture[nx][ny] == stage) {
                        queue.add(new Pair(nx, ny));
                        check[nx][ny] = true;
                        stageArea++;
                    }
                }
            }
        }

        if (stage != 0 && max < stageArea) {
            max = stageArea;
        }
    }

    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        check = new boolean[m][n];
        max = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!check[i][j]) {
                    int stage = picture[i][j];
                    bfs(i, j, m, n, stage, picture);
                    if (stage != 0) {
                        numberOfArea++;
                    }
                }
            }
        }
        maxSizeOfOneArea = max;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
}