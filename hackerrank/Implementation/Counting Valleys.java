import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int ans = 0;                        // 계곡의 수
        boolean currentValley = false;      // 현재 코스가 계곡인지
        int seaLevel = 0;                   // 깊이

        for(int i=0; i<n; i++){
            if(s.charAt(i) == 'D'){         // Down Hill 일때
                if(seaLevel == 0){          // 해수면이면 
                    // 계곡 시작
                    currentValley = true;   // 계곡으로 진입
                }
                seaLevel--;                 
            } else if(s.charAt(i) == 'U'){  // Up Hill 일때
                if(seaLevel == -1){         // 해수면 직전이면
                    if(currentValley){
                        ans++;              // 계곡의 수 카운트
                        currentValley = false;  // 계곡에서 벗어남
                    }
                }
                seaLevel++;
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String s = scanner.nextLine();

        int result = countingValleys(n, s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
