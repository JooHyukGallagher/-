import java.util.*;

public class Main {
    static boolean[] check;
    static boolean[] isCycle;
    static boolean foundCycle;
    static int[] dist;

    static ArrayList<Integer>[] arr;

    static int n;

    static void dfs(int start, int current, int cnt) {
        if (start == current && cnt >= 2) {
            foundCycle = true;
            return;
        }

        check[current] = true;      // 방문 완료
        for (int next : arr[current]) {
            if (!check[next]) {  // 처음 방문 일 경우
                dfs(start, next, cnt + 1);
            } else if (next == start && cnt >= 2) {
                dfs(start, next, cnt);
            }
            if (foundCycle) return;
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (isCycle[i]) {
                dist[i] = 0;
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int current = queue.remove();
            for (int next : arr[current]) {
                if (dist[next] == -1) {
                    queue.add(next);
                    dist[next] = dist[current] + 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        arr = new ArrayList[n];
        isCycle = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new ArrayList<>();
        }
        // 인접 리스트 입력
        for (int i = 0; i < n; i++) {
            int begin = scanner.nextInt();
            int last = scanner.nextInt();
            begin -= 1;
            last -= 1;
            arr[begin].add(last);
            arr[last].add(begin);
        }
        // 각 정점이 순환선인지 판별
        for (int i = 0; i < n; i++) {
            foundCycle = false;
            check = new boolean[n];
            dfs(i, i, 0);
            if (foundCycle) isCycle[i] = true;
        }


        // 거리 계산
        dist = new int[n];
        Arrays.fill(dist, -1);
        bfs();

        for (int i = 0; i < n; i++) {
            System.out.print(dist[i] + " ");
        }
        System.out.println();
    }
}
