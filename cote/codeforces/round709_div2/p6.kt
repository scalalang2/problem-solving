import java.util.*

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    (0 until m).forEach {
        val (u, v, w) = readLine()!!.split(" ").map { it.toInt() }
    }

    val q = readLine()!!.toInt()
    (0 until q).forEach {
        val (u, v, l) = readLine()!!.split(" ").map { it.toInt() }
    }
}