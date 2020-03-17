import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the timeConversion function below.
     */
    static String timeConversion(String s) {
        /*
         * Write your code here.
         */
        StringBuilder sb = new StringBuilder();
        String flag = s.substring(8,10);
        int hours;
        if(flag.equals("AM")){
            if(s.substring(0,2).equals("12")){
                sb.append("00");
                sb.append(s.substring(2,8));
            } else {
                sb.append(s.substring(0,8));
            }
        } else {
            if(s.substring(0,2).equals("12")){
                sb.append(s.substring(0,8));
            } else if(s.substring(0,1).equals("0")) {
                hours = Integer.parseInt(s.substring(1,2)) + 12;
                sb.append(hours);
                sb.append(s.substring(2,8));
            } else {
                hours = Integer.parseInt(s.substring(0,2)) + 12;
                sb.append(hours);
                sb.append(s.substring(2,8));
            }
        }
        return sb.toString();

    }

    private static final Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = scan.nextLine();

        String result = timeConversion(s);

        bw.write(result);
        bw.newLine();

        bw.close();
    }
}
