import java.util.*;

public class Main01 {
    static class Pair implements Comparable<Pair> {
        String name;
        int score;

        public Pair(String name, int score) {
            this.name = name;
            this.score = score;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.score, o.score);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        List<Pair> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String[] command = scanner.nextLine().split(" ");
            Pair p = new Pair(command[0], Integer.parseInt(command[1]));
            list.add(p);
        }

        Collections.sort(list);
        for (Pair p : list) {
            System.out.print(p.name + " ");
        }

    }
}
