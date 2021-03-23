package binary_search

import java.util.*

fun possible(lines: LongArray, len: Long, k:Int, n: Int): Boolean {
    var cnt:Long = 0
    for (el in 0 until k) {
        cnt += lines[el] / len
    }
    return cnt >= n
}

fun main(arr: Array<String>) {
    val reader = Scanner(System.`in`)
    val lines = LongArray(10000)

    val k = reader.nextInt()
    val n = reader.nextInt()

    for (i in 0 until k) {
        lines[i] = reader.nextLong()
    }

    var result:Long = 0
    var low:Long = 1
    var high:Long = 0

    // sort lines descending order.
    lines.sortDescending(0, k)
    high = lines[0]

    possible(lines, 2, k, n)

    while(low <= high) {
        val mid:Long = (low + high) / 2
        if(mid == 0.toLong()) break
        if(possible(lines, mid, k, n)) {
            if(result < mid)
                result = mid
            low = mid + 1
        } else {
            high = mid - 1
        }
    }

    println("%d".format(result))
}