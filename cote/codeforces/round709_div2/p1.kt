import java.util.*

fun main() {
    val t = readLine()!!.toInt()

    (0 until t).forEach {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }
        println(a * b)
    }
}