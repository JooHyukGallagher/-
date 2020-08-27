import java.util.Scanner;

public class exam01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] position = scanner.nextLine().toCharArray();

        int row = position[1] - '1';
        int column = position[0] - 'a';
        int[] dRow = {1, -1, 1, -1, 2, 2, -2, -2};
        int[] dColumn = {-2, -2, 2, 2, -1, 1, -1, 1};

        int answer = 0;
        for (int i = 0; i < 8; i++) {
            int newRow = row + dRow[i];
            int newColumn = column + dColumn[i];
            if (0 <= newRow && newRow < 8 && 0 <= newColumn && newColumn < 8) {
                answer++;
            }
        }
        System.out.println(answer);
    }
}
