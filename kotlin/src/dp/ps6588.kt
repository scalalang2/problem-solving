package dp

import java.util.*
import kotlin.math.sqrt

fun main(arr: Array<String>) {
    val reader = Scanner(System.`in`)
    val check = BooleanArray(1000000 + 1)

    // 0..100000, 양 끝의 값을 포함한 반복문이다.
    // 에라토스 테네스의 체
    for (i in 0..1000000) check[i] = true
    val sqrted = sqrt(1000000.0).toInt()
    for (i in 2..sqrted) {
        for (j in (i+i)..1000000 step i) {
            if(check[j]) check[j] = false
        }
    }


    while(true) {
        var n = reader.nextInt();
        if(n == 0) break

        var i = 3;
        while(true) {
            if(n - i < 0) {
                println("Goldbach's conjecture is wrong.")
                break
            }

            if(check[i] && check[n-i]) {
                println("%d = %d + %d".format(n, i, n - i))
                break;
            }
            i++
        }
    }
}