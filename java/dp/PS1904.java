import java.util.*;
import java.io.*;

class ProblemSolver {
    private int n;
    private int[] dp;

    public ProblemSolver(int n) {
        this.n = n;
        this.dp = new int[n + 1];

        for(int i = 0; i < n+1; i++)
            this.dp[i] = -1;
    }

    public int solve(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;

        if(this.dp[n] != -1) return this.dp[n];

        int result = (solve(n - 1) + solve(n - 2)) % 15746;
        this.dp[n] = result;

        return result;
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.next());
        ProblemSolver ps = new ProblemSolver(n);
        System.out.println(ps.solve(n));
    }
}