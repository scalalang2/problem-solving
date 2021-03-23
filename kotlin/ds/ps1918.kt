package main

import java.util.*

fun isOperation(expr:Char): Boolean {
    return expr == '+' || expr == '-' || expr == '*' || expr == '/' || expr == '(' || expr == ')'
}

fun main() {
    val sc = Scanner(System.`in`)
    val expr = sc.nextLine().toCharArray()
    var result = ""
    val priority = mapOf<Char, Int>('+' to 1, '-' to 1, '*' to 2, '/' to 2)

    // dequeue를 이용하면 queue로도 사용할 수 있고, stack으로도 사용이 가능하다.
    val stack = ArrayDeque<Char>()

    // a+b*c-(d*e+f)*g
    // +*-
    for(el in expr) {
        if(isOperation(el)) {
            if(el == '(') {
                stack.push(el)
            } else if(el == ')') {
                // println("-----")
                // println(result)
                // println(stack)
                while(!(stack.peek() == '(')) {
                    result += stack.pop()
                }
                stack.pop()
            } else {
                if(stack.isEmpty() || stack.peek() == '(' || priority.getValue(el) > priority.getValue(stack.peek())) {
                    stack.push(el)
                    // println("-----")
                    // println(result)
                    // println(stack)
                } else {
                    // println("-----")
                    // println(result)
                    // println(stack)
                    while(!(stack.isEmpty() || stack.peek() == '(' || priority.getValue(el) > priority.getValue(stack.peek()))) {
                        result += stack.pop()
                    }
                    stack.push(el)
                }   
            }
        } else {
            result += el
        }
    }

    while(!stack.isEmpty()) {
        val el = stack.pop()
        if(!(el == '(' || el == ')'))
            result += el
    }

    println(result)
}