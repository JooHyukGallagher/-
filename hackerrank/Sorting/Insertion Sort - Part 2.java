import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
    static void print(int[] arr){
        Arrays.stream(arr).forEach(a -> {
            System.out.print(a + " ");
        });
        System.out.println();
    }

    // Complete the insertionSort2 function below.
    static void insertionSort2(int n, int[] arr) {
        int num = 0;
        int i,j;
        for(i=1; i<n; i++){
            num = arr[i];
            for(j=i-1; j>=0; j--){
                if(num < arr[j]){
                    arr[j+1] = arr[j];
                } else {
                    break;
                }
            }
            j++;
            arr[j] = num;
            print(arr);
        }
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        insertionSort2(n, arr);

        scanner.close();
    }
}
