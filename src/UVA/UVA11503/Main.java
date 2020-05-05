package UVA.UVA11503;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    static int[] parents, rank;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();

            parents = new int[n * 2 + 1];
            rank = new int[n * 2 + 1];
            for (int i = 1; i < parents.length; i++) {
                parents[i] = i;
                rank[i] = 1;
            }

            Map<String, Integer> map = new HashMap();
            int idx = 1;
            for (int i = 0; i < n; i++) {
                String f1 = sc.next();
                String f2 = sc.next();
                if (!map.containsKey(f1)) {
                    map.put(f1, idx);
                    idx++;
                }
                if (!map.containsKey(f2)) {
                    map.put(f2, idx);
                    idx++;
                }
                int a = map.get(f1);
                int b = map.get(f2);

                System.out.println(union(a, b));
            }

        }
    }

    public static int find(int a) {
        if (parents[a] == a) {
            return a;
        }

        return parents[a] = find(parents[a]);
    }

    public static int union(int a, int b) {
        int ap = find(a);
        int bp = find(b);
        if (ap != bp) {
            if (rank[ap] < rank[bp]) {
                parents[ap] = bp;
                return rank[bp] += rank[ap];
            }
            parents[bp] = ap;
            return rank[ap] += rank[bp];
        }
        return rank[ap];
    }

}
