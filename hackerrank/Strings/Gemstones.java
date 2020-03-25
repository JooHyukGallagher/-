import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gemstones function below.
    static int gemstones(String[] arr) {
        int index = 'z';
        boolean[] check = new boolean[index+1];

        for(int i='a'; i<='z'; i++){
            char c = (char)i;
            for(int j=0; j<arr[0].length(); j++){
                if(arr[0].charAt(j) == c){
                    check[i] = true;
                }
            }
        }

        for(int k = 1; k<arr.length; k++){
            String s = arr[k];
            for(int i='a'; i<='z'; i++){
                boolean[] check2 = new boolean[index+1];
                char c = (char)i;
                for(int j=0; j<s.length(); j++){
                    if(s.charAt(j) == c){
                        check2[i] = true;
                    }
                }
                if(check[i] == true && check2[i] == false){
                    check[i] = false;
                }
            }
        }

        int ans = 0;
        for(int i='a'; i<='z'; i++){
            if(check[i]){
                ans++;
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            String arrItem = scanner.nextLine();
            arr[i] = arrItem;
        }

        int result = gemstones(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
