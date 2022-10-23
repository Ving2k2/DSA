package Week1.SPOJ;

import java.util.*;

public class SLEXSORT {
    public static void main(String[] args) {
        var r = new Scanner(System.in);
        int n = r.nextInt(), c;
        while (n-- > 0) {
            var t = r.next();
            var w = new Stack<String>();
            for (c = r.nextInt(); c-- > 0;) w.add(r.next());
            w.sort((x,y) -> {
                int p = x.length();
                int q = y.length();
                int j = 0, z = 0;
                while (j < p && j < q && z == 0) {
                    z = t.indexOf(x.charAt(j)) - t.indexOf(y.charAt(j++));
                }
                return z != 0 ? z : p - q;
            });
            w.forEach(System.out::println);
        }
    }
}
