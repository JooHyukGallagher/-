import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the makingAnagrams function below.
    static int makingAnagrams(String s1, String s2) {
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for(int i=0; i<c1.length; i++){
            int index = c1[i] - 'a';
            arr1[index]++;
        }

        for(int i=0; i<c2.length; i++){
            int index = c2[i] - 'a';
            arr2[index]++;
        }

        int count = 0;
        for(int i=0; i<26; i++){
            int result = Math.abs(arr1[i] - arr2[i]);
            count += result;
        }

        return count;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s1 = scanner.nextLine();

        String s2 = scanner.nextLine();

        int result = makingAnagrams(s1, s2);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
