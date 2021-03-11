import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.next());
        int k = Integer.parseInt(sc.next());

        int[] w = new int[n];
        int[] val = new int[n];
        int[][] dp = new int[n + 1][k + 1];

        for(int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(sc.next());
            val[i] = Integer.parseInt(sc.next());
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= k; j++) {
                if(w[i-1] <= j) {
                    // i 번째 아이템을 포함시킨다.
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i-1]] + val[i-1]);
                } else {
                    // i 번째 아이템을 포함시키지 못한다.
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println(dp[n][k]);
    }
}