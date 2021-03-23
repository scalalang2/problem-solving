import java.util.*

// 아 요즘 왜이리 잔실수가 많지

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val x = readLine()!!.toInt()
    arr.sort()

    var ans = 0
    var st = 0
    var ed = arr.size - 1

    while(st < ed) {
        if(arr[st] + arr[ed] == x) {
            st++
            ed--
            ans++
        } else if(arr[st] + arr[ed] > x) {
            ed--
        } else {
            st++
        }
    }

    println(ans)
}