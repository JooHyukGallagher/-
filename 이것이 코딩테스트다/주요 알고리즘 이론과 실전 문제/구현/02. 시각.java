import java.util.Scanner;

public class exam01 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int answer = 0;
        String str = "";
        int h, m, s;
        for (h=0; h<=n; h++) {
            for (m=0; m<60; m++) {
                for (s=0; s<60; s++) {
                    str = "" + h + m + s;
                    if (str.contains("3")) {
                        answer++;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
