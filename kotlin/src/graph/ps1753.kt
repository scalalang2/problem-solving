package graph

import java.util.*;

const val MAX = 20000
const val INF = 1000000000

var graph: MutableList<MutableList<Pair<Int, Int>>> = mutableListOf()
var distances:IntArray = IntArray(MAX)
var visited:BooleanArray = BooleanArray(MAX)

fun main() {
    val sc = Scanner(System.`in`)
    val (nodes, edges) = sc.nextLine().split(" ").map { it.toInt() }
    val start_node = sc.nextLine().toInt() - 1

    // graph에 노드를 추가한다.
    (0 until nodes).forEach { graph.add(mutableListOf()) }

    for (i in 0 until edges) {
        val tmp = sc.nextLine()
        val (u, v, w) = tmp.split(" ").map { it.toInt() }
        graph[u-1].add(Pair(v-1, w))
    }

    // INF 값으로 채운다.
    distances.fill(INF)
    visited.fill(false)

    // 시작 지점은 0으로 초기화 한다.
    distances[start_node] = 0

    val comparator:Comparator<Pair<Int, Int>> = compareBy { it.first }
    var Q = PriorityQueue<Pair<Int, Int>>(comparator)
    Q.add(Pair(0, start_node))

    while(Q.isNotEmpty()) {
        var (dist, curr) = Q.remove()

        if(!visited[curr]) {
            visited[curr] = true
            graph[curr].forEach {
                val next_node = it.first
                val next_dist = it.second

                if (dist + next_dist < distances[next_node]) {
                    distances[next_node] = dist + next_dist
                    Q.add(Pair(distances[next_node], next_node))
                }
            }
        }
    }

    (0 until nodes).forEach {
        if(distances[it] == INF) println("INF")
        else println(distances[it])
    }
}