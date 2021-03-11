import java.util.*;

// 11057 오르막 수 
class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.next());
        int[][] dp = new int[n][10];

        // 첫번째 자리수를 모두 1로 초기화 한다.
        for(int i = 0; i < 10; i++) {
            dp[0][i] = 1;
        }

        for(int i = 1; i < n; i++) {
            for(int j = 0; j < 10; j++) {
                for(int k = j; k < 10; k++) {
                    dp[i][j] = (dp[i][j] + dp[i-1][k]) % 10007;
                }
            }
        }

        int ans = 0;
        for(int i = 0; i < 10; i++) {
            ans = (ans + dp[n-1][i]) % 10007;
        }

        System.out.println(ans);
    }
}