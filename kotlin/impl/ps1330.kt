import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val (a, b) = sc.nextLine().split(" ").map { it.toInt() }
    if(a < b) {
        println("<")
    } else if(a > b) {
        println(">")
    } else {
        println("==")
    }
}