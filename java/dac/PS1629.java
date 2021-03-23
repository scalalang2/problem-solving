import java.util.*;
import java.io.*;

class Solution {
    public static long solve(long a, long b, long c) {
        if(b == 0) return 1;
        if(b == 1) return a%c;

        if(b % 2 == 0) {
            long y = solve(a, b/2, c);
            return (y%c) * (y%c) % c;
        } else {
            long y = solve(a, (b-1)/2, c);
            return (y%c) * (y%c) * (a%c) % c;
        }
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();

        System.out.println(Solution.solve(A, B, C));
    }
}