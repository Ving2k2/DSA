package Week1.SPOJ;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class SLEXSORT {
    public static void main(String[] args) {
        var r = new Scanner(System.in);
        int n = r.nextInt();
        while (n-- > 0) {
            var t = r.next();
            var w = new String[r.nextInt()];
            Arrays.setAll(w,i->r.next());
            Arrays.sort(w,(x,y) -> {
                int p = x.length();
                int q = y.length();
                int j = 0, z = 0;
                while (j < p && j < q) {
                    z = t.indexOf(x.charAt(j)) - t.indexOf(y.charAt(j++));
                    if(z != 0) return z;
                }
                return p - q;
            });
            for (var z : w) System.out.println(z);
            System.out.println();
        }
    }
}
