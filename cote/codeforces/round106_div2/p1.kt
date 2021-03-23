import java.util.*

/*
5
1 0 1
1 0
1 1 1
0 0
3 0 0
1 3
4 3 1
2 2
5 4 3
3 1
 */

fun main() {
    val t = readLine()!!.toInt()
    (0 until t).forEach {
        val (n, k1, k2) = readLine()!!.split(" ").map { it.toInt() }
        val (w, b) = readLine()!!.split(" ").map { it.toInt() }

        // 0 = black, 1 = white
        val board = Array<IntArray>(2) { IntArray(n + 1) { 0 } }
        val dp_w = IntArray(n + 1) { 0 }
        val dp_b = IntArray(n + 1) { 0 }

        board[0][0] = -1
        board[1][0] = -1
        (1..k1).forEach { board[0][it] = 1 }
        (1..k2).forEach { board[1][it] = 1 }

        (1..n).forEach { 
            var ans = dp_w[it-1]
            if(board[0][it] == 1 && board[1][it] == 1) {
                ans = Math.max(ans, dp_w[it-1] + 1)
            }

            if(board[0][it-1] == 1 && board[0][it] == 1) {
                ans = Math.max(ans, dp_w[it-2] + 1)
            }

            if(board[1][it-1] == 1 && board[1][it] == 1) {
                ans = Math.max(ans, dp_w[it-2] + 1)
            }
            dp_w[it] = ans

            var ans_b = dp_b[it-1]
            if(board[0][it] == 0 && board[1][it] == 0) {
                ans_b = Math.max(ans_b, dp_b[it-1] + 1)
            }

            if(board[0][it-1] == 0 && board[0][it] == 0) {
                ans_b = Math.max(ans_b, dp_b[it-2] + 1)
            }

            if(board[1][it-1] == 0 && board[1][it] == 0) {
                ans_b = Math.max(ans_b, dp_b[it-2] + 1)
            }
            dp_b[it] = ans_b
        }

        if(w <= dp_w[n] && b <= dp_b[n]) {
            println("YES")
        } else {
            println("NO")
        }
    }
}