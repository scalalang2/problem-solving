import java.util.*

fun main() {
    val (height, width) = readLine()!!.split(" ").map { it.toInt() }
    val verticalLines = readLine()!!.split(" ").map { it.toInt() }

    var answer = 0
    for (i in 1..height) {
        var prevWidth = -1
        for(j in 0 until width) {
            if(i <= verticalLines[j]) {
                if(prevWidth != -1 && j - prevWidth > 1) {
                    answer += j - prevWidth - 1
                }
                prevWidth = j
            }
        }
    }

    println(answer)
}