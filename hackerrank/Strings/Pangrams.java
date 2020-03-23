import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the pangrams function below.
    static String pangrams(String s) {
        int[] map = new int[123];
        for(int i=0; i<s.length(); i++){
            int index = s.charAt(i);
            map[index]++;
        }

        boolean ok = true;
        for(int i='A'; i<='Z'; i++){
            int index = i;
            if(map[index] <= 0 && map[index+32] <= 0){
                ok = false;
                break;
            }
        }

        if(ok){
            return "pangram";
        } else {
            return "not pangram";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = pangrams(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
