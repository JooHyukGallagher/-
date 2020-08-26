import java.util.Scanner;

public class exam01 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] command = scanner.nextLine().split(" ");

        int row = 1;
        int column = 1;
        for (String com : command) {
            if (com.equals("R")) {
                if (column < n) {
                    column++;
                }
            } else if(com.equals("L")) {
                if (column > 1) {
                    column--;
                }
            } else if(com.equals("U")) {
                if (row > 1) {
                    row--;
                }
            } else if(com.equals("D")) {
                if (row < n) {
                    row++;
                }
            }
        }

        System.out.println(row + " " + column);
    }
}
