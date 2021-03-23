import java.util.*

fun gcd(a:Int, b:Int): Int {
    var _a = a
    var _b = b
    while(_b != 0) {
        var _t = _a % _b
        _a = _b
        _b = _t
    }

    return _a
}

fun _gcd(a:Int, b:Int): Int {
    if(b != 0) return _gcd(b, a%b)
    else return b
}

fun lcd(a:Int, b: Int, c: Int): Int {
    return (a * b) / c 
}

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    val _gcd = gcd(Math.max(a, b), Math.min(a, b))
    val _lcd = lcd(a, b, _gcd)

    println("$_gcd")
    println("$_lcd")
}