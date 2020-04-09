import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the gameOfThrones function below.
    static String gameOfThrones(String s) {
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            int index = c - 'a';
            map[index]++;
        }

        int oddAlpaNum = 0;
        for(int i=0; i<map.length; i++){
            if(map[i] != 0 && map[i] % 2 != 0){
                oddAlpaNum++;
            }
        }

        if(oddAlpaNum >= 2){
            return "NO";
        } else {
            return "YES";
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scanner.nextLine();

        String result = gameOfThrones(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
