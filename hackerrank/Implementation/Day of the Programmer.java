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

    // Complete the dayOfProgrammer function below.
    static String dayOfProgrammer(int year) {
        //Initialize DOY, month, and day ints for return string
        int dayOfYear = 256;
        int resultMonth = 0;
        int resultDay = 0; 

        //intialize array to hold # of days in each month
        int[] daysPerMonth = {0,31,28,31,30,31,30,31,31,30,31,30,31};

        //conditions to determine months in Feb (if not 28)
        if(year == 1918){
            daysPerMonth[2] -= 13;
        }
        else if((year < 1918 && year % 4 == 0) || (year > 1918 && ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)))){
            daysPerMonth[2]++;
        }

        for(int month = 1; month <= 12; month++){
            resultMonth = month;
            dayOfYear -= daysPerMonth[month];
            if(dayOfYear < 0){
                dayOfYear += daysPerMonth[month];
                // resultMonth--;
                break;
            }
        }
        String m = String.valueOf(resultMonth);
        if(m.length() < 2){
            m = "0" + m;
        }
        String d = String.valueOf(dayOfYear);
        if(d.length() < 2){
            d = "0" + d;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(d);
        sb.append(".");
        sb.append(m);
        sb.append(".");
        sb.append(year);

        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int year = Integer.parseInt(bufferedReader.readLine().trim());

        String result = dayOfProgrammer(year);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
