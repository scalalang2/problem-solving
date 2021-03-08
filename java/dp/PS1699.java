import java.util.*;
import java.io.*;

class ProblemSolver {
    private int n;
    private int[] dp;
    private ArrayList<Integer> cost;

    public ProblemSolver(int n) {
        this.dp = new int[n + 1];
        this.cost = new ArrayList<>();
        for(int i = 0; i < n + 1; i++)
            this.dp[i] = 99999;

        this.dp[0] = 0;
        this.dp[1] = 1;

        int i = 1;
        int k = 0;
        while(k <= n) {
            k = (int) Math.pow(i, 2);
            this.cost.add(k);
            i++;
        }
    }

    public void showCost() {
        for(int i = 0; i < this.cost.size(); i++) {
            System.out.println(this.cost.get(i));
        }
    }

    public int solve(int k) {
        if(dp[k] != 99999) return dp[k];
        if(k == 1) return 1;
        if(k == 0) return 0;

        for(int i = 0; i < this.cost.size(); i++) {
            int c = this.cost.get(i);
            if(k-c >= 0) {
                dp[k] = Math.min(dp[k], solve(k-c) + 1);
                // System.out.println("k:" + k + ", c:" + c + ", " + (solve(k-c) + 1));
            }
        }

        return dp[k];
    }
}

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());

        ProblemSolver ps = new ProblemSolver(n);
        System.out.println(ps.solve(n));
        // ps.showCost();
    }
}