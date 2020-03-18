import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the luckBalance function below.
    static int luckBalance(int k, int[][] contests) {
        int ans = 0;
        
        int imContestLength = 0;
        for(int i=0; i<contests.length; i++){
            if(contests[i][1] == 0){
                ans += contests[i][0];
            }
            if(contests[i][1] == 1){
                imContestLength++;
            }
        }

        int[] imcon = new int[imContestLength];
        int idx = 0;
        for(int i=0; i<contests.length; i++){
            if(contests[i][1] == 1){
                imcon[idx] = contests[i][0];
                idx++;
            }
        }

        Arrays.sort(imcon);

        if(imContestLength > k) {
            for(int i=0; i<imContestLength-k; i++){
                ans -= imcon[i];
            }
            for(int i=imContestLength-1; i>=imContestLength-k; i--){
                ans += imcon[i];
            }
        } else {
            for(int i=0; i<imContestLength; i++){
                ans += imcon[i];
            }
        }

        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        int[][] contests = new int[n][2];

        for (int i = 0; i < n; i++) {
            String[] contestsRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int contestsItem = Integer.parseInt(contestsRowItems[j]);
                contests[i][j] = contestsItem;
            }
        }

        int result = luckBalance(k, contests);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
