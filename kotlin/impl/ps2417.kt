import java.util.*

fun main() {
    val n = readLine()!!.toLong()
    val q = Math.sqrt(n.toDouble()).toLong()
    if(q * q == n) {
        println(q)
    } else {
        println(q+1L)
    }
}