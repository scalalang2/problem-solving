package main

import java.util.*

// 그래프
var graph = List<MutableList<Int>>(401) { mutableListOf() } 

// 간선의 유량
var flow = Array(401) { Array<Int>(401) { 0 } }

// 간선의 용량
var cap = Array(401) { Array<Int>(401) { 0 } }

fun main() {
    val (N, P) = readLine()!!.split(" ").map { it.toInt() }

    (0 until P).forEach {
        // 그래프의 값을 초기화 한다.
        val (u, v) = readLine()!!.split(" ").map { it.toInt() }
        graph[u].add(v)
        graph[v].add(u)
        cap[u][v] = 1
        cap[v][u] = 0
    }

    val S = 1
    val E = 2 // S=시작, E=도착 지점
    var totalFlow = 0 // 총 유량

    while(true) {
        val queue: Queue<Int> = LinkedList<Int>()
        val path = IntArray(401) { -1 }
        queue.add(S)

        while(!queue.isEmpty() && path[E] == -1) {
            val curr = queue.remove()
            for(next in graph[curr]) {
                if(path[next] == -1 && cap[curr][next] - flow[curr][next] > 0) {
                    path[next] = curr
                    queue.add(next)
                    if(next == E) break
                }
            }
        }

        // 더 이상 증가 경로가 없다면 유량을 출력하고 프로그램을 종료한다.
        if(path[E] == -1) {
            println(totalFlow)
            break
        }

        var minFlow = Int.MAX_VALUE
        var curr = E
        while(curr != S) {
            val prev = path[curr]
            minFlow = Math.min(minFlow, cap[prev][curr] - flow[prev][curr])
            curr = prev
        }

        curr = E
        while(curr != S) {
            val prev = path[curr]
            flow[prev][curr] += minFlow
            flow[curr][prev] -= minFlow
            curr = prev
        }

        totalFlow += minFlow
    }
}