import java.util.*

/*
5
10101011011
0000
11111
110
1100
*/
fun main() {
    val t = readLine()!!.toInt()
    (0 until t).forEach {
        val s = readLine()!!.map(Character::getNumericValue)

        // 초기화
        val arr = IntArray(s.size+4) { 0 }
        for(i in 3 until (s.size+3))
            arr[i] = s[i-3]
        arr[s.size+3] = 1

        val dp = Array<BooleanArray>(2){ BooleanArray(s.size+3) { false } }
        dp[0][0] = true
        dp[1][0] = true
        dp[0][1] = true
        dp[1][1] = true
        dp[0][2] = true
        dp[1][2] = true

        val REMOVE = 0
        val NOT_REMOVE = 1

        for(i in 3 until (s.size+3)) {
            var ans_1 = false
            ans_1 = ans_1 || (dp[NOT_REMOVE][i-1] && arr[i-1] <= arr[i+1])
            dp[REMOVE][i] = ans_1

            var ans = false
            ans = ans || (dp[REMOVE][i-1] && arr[i-2] <= arr[i])
            ans = ans || (dp[NOT_REMOVE][i-1] && arr[i-1] <= arr[i])
            dp[NOT_REMOVE][i] = ans
        }
        if(dp[REMOVE][s.size+2] || dp[NOT_REMOVE][s.size+2]) {
            println("YES")
        } else {
            println("NO")
        }
    }
}