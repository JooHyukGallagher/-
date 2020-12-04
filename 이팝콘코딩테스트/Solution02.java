package 이팝콘코딩테스트;

import java.util.Scanner;

public class Solution02 {
    static int operation(int a, int b, String opt) {
        switch (opt) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                return a / b;
        }
        return 0;
    }

    static int inputNumber(String name) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("숫자 " + name + "를 입력하시오.");
        int number;
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                String[] lengthOfInput = scanner.nextLine().split(" ");
                if (lengthOfInput.length != 1) {
                    System.out.println("1개의 숫자만 입력하세요.");
                } else {
                    break;
                }
            } else {
                System.out.println("정수를 입력하세요.");
            }
            scanner.next();
        }
        return number;
    }

    static String inputOperator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("수행할 연산을 입력하시오.");
        String operator;

        while (true) {
            operator = scanner.nextLine();
            if (!operator.equals("+") && !operator.equals("-") && !operator.equals("/") && !operator.equals("*")) {
                System.out.println("제대로 된 연산자가 아닙니다.");
                System.out.println("연산자를 다시 입력해주세요.");
            } else {
                break;
            }
        }

        return operator;
    }

    public static void main(String[] args) {

        int a, b;
        String opt;

        a = inputNumber("A");
        b = inputNumber("B");

        opt = inputOperator();

        int answer = operation(a, b, opt);
        System.out.println("숫자 A: " + answer);
    }

}
