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

    static boolean isAlter(String s) {
        boolean ok = true;

        for (int i = 1; i < s.length() - 1; i++) {
            if (s.charAt(i - 1) == s.charAt(i + 1) && s.charAt(i - 1) != s.charAt(i)) continue;
            else {
                ok = false;
                break;
            }
        }

        return ok;
    }

    private static String form(char a, char b, String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == a){
                stringBuilder.append(a);
            }
            if (s.charAt(i) == b){
                stringBuilder.append(b);
            }
        }
        return stringBuilder.toString();
    }

    static int twoCharacters(String s, String noDup) {
        // 문자열이 2개인 경우 서로 다를 경우 만족하기 때문에 문자열 길이 그대로 리턴
        if (s.length() == 2) {
            if (s.charAt(0) != s.charAt(1)) {
                return 2;
            }
        }

        // 기존 문자열에서 문자 2개를 다빼서 새로운 문자열로 만들기
        int temp = 0;
        for(int i=0; i<noDup.length(); i++){
            char a = noDup.charAt(i);
            for(int j = i+1; j<noDup.length(); j++){
                char b = noDup.charAt(j);
                String t = form(a, b, s);
                if (isAlter(t)){
                    if (t.length() > temp) {
                        temp = t.length();
                    }
                }
            }
        }

        return temp;
    }

    static String distinctStr(String s){
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()){
            set.add(c);
        }

        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Character> iterator = set.iterator();
        while(iterator.hasNext()){
            stringBuilder.append(iterator.next());
        }
        
        return stringBuilder.toString();
    }

    static int alternate(String s) {
        String distinctStr = distinctStr(s);
        return twoCharacters(s, distinctStr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int l = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int result = alternate(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
