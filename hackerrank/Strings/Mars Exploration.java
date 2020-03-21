import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the marsExploration function below.
    static int marsExploration(String s) {
        int ans = 0;
        String p = "SOS";
        for(int i=0; i<s.length(); i+=3){
            String str = s.substring(i, i+3);
            if(str.charAt(0) != 'S'){
                ans++;
            }
            if(str.charAt(1) != 'O'){
                ans++;
            }
            if(str.charAt(2) != 'S'){
                ans++;
            }
        }
        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        int result = marsExploration(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
