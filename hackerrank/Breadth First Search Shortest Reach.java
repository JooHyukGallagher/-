import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the bfs function below.
    static int[] bfs(int n, int m, int[][] edges, int s) {
        
        ArrayList<Integer>[] arr = new ArrayList[n+1];
        for(int i=1; i<=n; i++){
            arr[i] = new ArrayList<>();
        }
        for(int i=0; i<m; i++){
            arr[edges[i][0]].add(edges[i][1]);
            arr[edges[i][1]].add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] check = new boolean[n+1];
        int[] dist = new int[n+1];
        
        check[s] = true;
        dist[s] = 0;
        q.add(s);

        while(!q.isEmpty()){
            int num = q.poll();
            for(int x : arr[num]){
                if(!check[x]){
                    check[x] = true;
                    dist[x] = dist[num] + 1;
                    q.add(x);
                }
            }
        }
        
    
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=1; i<=n; i++){
            if(i == s) continue;
            if(check[i]){
                result.add(dist[i] * 6);
            } else {
                result.add(-1);
            }
        }

        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        return answer;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String[] nm = scanner.nextLine().split(" ");

            int n = Integer.parseInt(nm[0]);

            int m = Integer.parseInt(nm[1]);

            int[][] edges = new int[m][2];

            for (int i = 0; i < m; i++) {
                String[] edgesRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int edgesItem = Integer.parseInt(edgesRowItems[j]);
                    edges[i][j] = edgesItem;
                }
            }

            int s = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] result = bfs(n, m, edges, s);

            for (int i = 0; i < result.length; i++) {
                bufferedWriter.write(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    bufferedWriter.write(" ");
                }
            }

            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
