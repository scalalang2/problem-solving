import java.util.*

val MIN = -1000001
val MAX = 1000001

fun main() {
    val t = readLine()!!.toInt()
    (0 until t).forEach {
        var min_value = MAX
        var max_value = MIN

        readLine()!!
        readLine()!!.split(" ").forEach {
            val value = it.toInt()
            min_value = Math.min(value, min_value)
            max_value = Math.max(value, max_value)
        }

        println("$min_value $max_value")
    }
}