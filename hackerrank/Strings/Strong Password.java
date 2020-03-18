import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the minimumNumber function below.
    static int minimumNumber(int n, String password) {
        // Return the minimum number of characters to make the password strong
        String numbers = "0123456789";
        String lower_case = "abcdefghijklmnopqrstuvwxyz";
        String upper_case = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special_characters = "!@#$%^&*()-+";

        boolean isNumbers = false;
        boolean isLowerCase = false;
        boolean isUpperCase = false;
        boolean isSpecialCharacters = false;
        boolean isLengthOverSix = false;

        int ans = 0;
        for(int i=0; i<n; i++){
            char element = password.charAt(i);     
            if('0' <= element && element <= '9'){       // 숫자가 포함이 되어있는지
                if(!isNumbers){
                    isNumbers = true;
                }
            }
            if('a' <= element && element <= 'z'){       // 소문자가 포함이 되어있는지
                if(!isLowerCase){
                    isLowerCase = true;
                }
            }
            if('A' <= element && element <= 'Z'){       // 대문자가 포함이 되어있는지
                if(!isUpperCase){
                    isUpperCase = true;
                }
            }
            if(special_characters.contains(password.substring(i, i+1))){   // 특수 문자가 포함 되는지
                if(!isSpecialCharacters){
                    isSpecialCharacters = true;
                }
            }
        }
        
        if(!isNumbers){
            ans++;
        }
        if(!isLowerCase){
            ans++;
        }
        if(!isUpperCase){
            ans++;
        }
        if(!isSpecialCharacters){
            ans++;
        }

        if(n >= 6){
            return ans;
        } else {
            if(6-n >= ans){
                return 6-n;
            } else {
                return ans;
            }
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        String password = scanner.nextLine();

        int answer = minimumNumber(n, password);

        bufferedWriter.write(String.valueOf(answer));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
