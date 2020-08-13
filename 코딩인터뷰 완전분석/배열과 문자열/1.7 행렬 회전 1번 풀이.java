public class exam07_01 {
    static boolean rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) return false;
        int n = matrix.length;
        for (int layer = 0; layer < n / 2; layer++) {
            int first = layer;
            int last = n - 1 - layer;
            for (int i = first; i < last; i++) {
                int offset = i - first;
                int top = matrix[first][i];

                // 왼쪽 -> 위쪽
                matrix[first][i] = matrix[last-offset][first];

                // 아래쪽 -> 왼쪽
                matrix[last-offset][first] = matrix[last][last-offset];

                // 오른쪽 -> 아래쪽
                matrix[last][last-offset] = matrix[i][last];

                // 위쪽 -> 오른쪽
                matrix[i][last] = top;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] map = new int[4][4];
        int start = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                map[i][j] = start;
                start++;
            }
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }

        if (rotate(map)){
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
