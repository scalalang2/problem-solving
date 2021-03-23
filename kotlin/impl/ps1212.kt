import java.util.*

val octalMap = mapOf(
    '0' to "000",
    '1' to "001",
    '2' to "010",
    '3' to "011",
    '4' to "100",
    '5' to "101",
    '6' to "110",
    '7' to "111"
)

fun trim(text: String): String {
    var hasOne = false
    var result = ""

    for(el in text) {
        if(!hasOne) {
            if(el == '1') {
                result += el
                hasOne = true
            }
        } else {
            result += el
        }
    }

    return result
}

fun main() {
    val text = readLine()!!
    val len = text.length
    if(text == "0") {
        print("0")
    } else {
        for(i in 0 until len) {
            if(i == 0) {
                print(trim(octalMap[text[i]]!!))
            } else {
                print(octalMap[text[i]])
            }
        }
    }
}