package dp

import java.util.*

fun solve(n: Int): Long {
    if(n < 3) {
        return 1
    } else {
        val dp = LongArray(101)
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 1;

        for (i in 3..n) {
            dp[i] = dp[i-3] + dp[i-2];
        }

        return dp[n-1];
    }
}

fun main(args: Array<String>) {
    val reader = Scanner(System.`in`)

    var t = reader.nextInt()
    while(t != 0) {
        val n = reader.nextInt()
        println(solve(n))
        t--
    }
}