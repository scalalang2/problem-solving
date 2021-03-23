package main

import java.util.*

// 피 연산자의 값들
val values: DoubleArray = DoubleArray(26)

fun isOperation(el: Char): Boolean {
    return el == '+' || el == '-' || el == '*' || el == '/'
}

fun calculate(a: Double, b: Double, el: Char): Double {
    val result:Double = when(el) {
        '+' -> a + b
        '-' -> a - b
        '*' -> a * b
        '/' -> a / b
        else -> 0.0
    }

    return result
}

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextLine().toInt()
    val text = sc.nextLine().toCharArray()

    (0 until n).forEach {
        values[it] = sc.nextLine().toDouble()
    }

    // stack
    val stack = ArrayDeque<Double>()
    for(el in text) {
        if(isOperation(el)) {
            val b = stack.pop()
            val a = stack.pop()
            // println("$a , $b , $el")
            stack.push(calculate(a, b, el))
        } else {
            stack.push(values[el - 'A'])
        }
    }

    val result = Math.floor((stack.pop() * 100.0f).toDouble()) / 100.0f
    println("%.2f".format(result))
}