import java.util.*

fun solve(n: Int, acc: Int): Boolean {
    if(n == acc) return true
    if(n < acc) return false

    val ans = solve(n, acc + 2020)
    val ans2 = solve(n, acc + 2021)

    return ans || ans2
}

fun main() {
    val t = readLine()!!.toInt()

    (0 until t).forEach {
        val n = readLine()!!.toInt()
        var ans = false
        var a = 0

        while(a * 2020 <= n) {
            if((n - a * 2020) % 2021 == 0) {
                ans = true
                break
            }
            a++
        }

        if(ans) {
            println("YES")
        } else {
            println("NO")
        }
    }
}