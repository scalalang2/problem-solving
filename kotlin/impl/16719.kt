import java.util.*

// ZOAC
fun solve(st: Int, ed: Int, stText: String, edText: String, charArr: CharArray): String {
    if(ed - st == 0) {
        println(stText + charArr[st] + edText)
        return stText + charArr[st] + edText
    } else if(st > ed) {
        return stText + edText
    } else {
        val sliced = charArr.slice(st..ed)
        val min = sliced.minOrNull()!!
        val index = sliced.indexOf(min)
        solve(st + index + 1, ed, stText + min, edText, charArr)
        solve(st, ed - index, stText, _ed, charArr)
        return ""
    }
}

fun main() {
    val charArr = readLine()!!.toCharArray()
    val ed = charArr.size - 1
    val st = 0

    solve(st, ed, "", "", charArr)
}