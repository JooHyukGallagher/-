import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static long ans = 0;

    static int[] peopleCountry;

    static void dfs1(int start, int c_code, boolean[] visited, ArrayList<Integer>[] arr){
        if(visited[start]){
            return;
        }

        visited[start] = true;
        peopleCountry[start] = c_code;
        
        for(int x : arr[start]){
            if(!visited[x]){
                dfs1(x, c_code, visited, arr);
            }
        }

    }

    // Complete the journeyToMoon function below.
    static long journeyToMoon(int n, int[][] astronaut) {
        // 그래프 생성        
        ArrayList<Integer>[] arr = new ArrayList[n];
        for(int i=0; i<n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<astronaut.length; i++){
            arr[astronaut[i][0]].add(astronaut[i][1]);
            arr[astronaut[i][1]].add(astronaut[i][0]);
        }

        peopleCountry = new int[n];
        
        // 각 사람마다 국가 코드 삽입하기 0~n
        int c_code = 0;
        boolean[] visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                dfs1(i, c_code, visited, arr);
                c_code++;
            }
        }

        // 국가별로 사람의 수를 표현하는 배열
        int[] peopleByCountry = new int[c_code];
        for(int i=0; i<n; i++){
            peopleByCountry[peopleCountry[i]]++;
        }

        int sum = 0;
        for(int i=0; i<c_code; i++){
            ans += sum * peopleByCountry[i];
            sum += peopleByCountry[i];
        }

        return ans;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] np = scanner.nextLine().split(" ");

        int n = Integer.parseInt(np[0]);

        int p = Integer.parseInt(np[1]);

        int[][] astronaut = new int[p][2];

        for (int i = 0; i < p; i++) {
            String[] astronautRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int astronautItem = Integer.parseInt(astronautRowItems[j]);
                astronaut[i][j] = astronautItem;
            }
        }

        long result = journeyToMoon(n, astronaut);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
