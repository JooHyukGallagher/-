import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {
    // Complete the superReducedString function below.
    static String superReducedString(String s) {
        boolean ok;
        while(true){
            ok = false;
            int i;
            for(i=0; i<s.length()-1; i++){
                if(s.charAt(i) == s.charAt(i+1)){
                    ok = true;
                    break;
                }
            }
            if(!ok){
                break;
            }
            s = s.substring(0, i) + s.substring(i+2, s.length());
        }

        if(s.equals("")){
            return "Empty String";
        } else {
            return s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        String result = superReducedString(s);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
