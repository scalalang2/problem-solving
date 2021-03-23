package main

import java.util.*;

val map = Array(10) { CharArray(10) { '0' }} 
val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, 1, 0, -1)

fun main() {
    val sc = Scanner(System.`in`)
    val (row, column) = sc.nextLine().split(" ").map { it.toInt() }

    // 사전 준비
    (0 until row).forEach {
        val y = it
        val text = sc.nextLine().toCharArray()
        (0 until column).forEach {
            val x = it
            map[y][x] = text[x]
        }
    }

    var cycle = false

    loop@ for(r in 0 until row) {
        for(c in 0 until column) {
            if(map[r][c] == 'X') continue
            var openPath = 0

            for(k in 0 until 4) {
                val next_x = c + dx[k]
                val next_y = r + dy[k]
                if(next_y >= 0 && next_y < row && next_x >= 0 && next_x < column) {
                    if(map[next_y][next_x] == '.') {
                        openPath++
                    }
                }
            }

            if(openPath <= 1) {
                cycle = true
                break@loop
            }
        }
    }

    if(cycle) {
        println(1)
    } else {
        println(0)
    }
}