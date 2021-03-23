import java.util.*

fun main() {
    val t = readLine()!!.toInt()

    (0 until t).forEach {
        val n = readLine()!!.toLong()
        // not even
        if(n % 2L == 1L) {
            println("YES")
        } else {
            println("NO")
        }
    }
}