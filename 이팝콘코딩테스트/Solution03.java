package 이팝콘코딩테스트;

import java.util.Arrays;

public class Solution03 {
    static int[] lottoNumber = new int[6];

    static boolean isInherence(int[] lottoNumber) {
        Arrays.sort(lottoNumber);
        for (int i = 0; i < lottoNumber.length - 1; i++) {
            if (lottoNumber[i] == lottoNumber[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                for (int i = 0; i < 6; i++) {
                    lottoNumber[i] = (int) (Math.random() * 45) + 1;
                }

                while (!isInherence(lottoNumber)) {
                    run();
                }

                for (int value : lottoNumber) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        };

        thread.start();
    }



}
