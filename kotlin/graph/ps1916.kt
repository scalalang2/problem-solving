package graph

import java.util.*;

fun main() {
    var graph: MutableList<MutableList<Pair<Int, Int>>> = mutableListOf()

    val sc = Scanner(System.`in`)
    val nodes = sc.nextLine().toInt()
    val edges = sc.nextLine().toInt()

    val dist = IntArray(nodes)
    val visited = BooleanArray(nodes)
    dist.fill(Int.MAX_VALUE)
    visited.fill(false)

    (0 until nodes).forEach {
        graph.add(mutableListOf())
    }

    (0 until edges).forEach {
        val tmp = sc.nextLine()
        val (u, v, w) = tmp.split(" ").map { it.toInt() }
        graph[u-1].add(Pair(v-1, w))
    }

    val (startNode, endNode) = sc.nextLine().split(" ").map { it.toInt() }

    val comparator: Comparator<Pair<Int, Int>> = compareBy { it.first }
    var Q:PriorityQueue<Pair<Int, Int>> = PriorityQueue(comparator)

    dist[startNode-1] = 0
    Q.add(Pair(0, startNode-1))

    loop@ while(Q.isNotEmpty()) {
        val (currDist, curr) = Q.remove()
        if(!visited[curr]) {
            visited[curr] = true
            for(item in graph[curr]) {
                val nextNode = item.first
                val nextWeight = item.second

                if(currDist + nextWeight < dist[nextNode]) {
                    dist[nextNode] = currDist + nextWeight
                    Q.add(Pair(dist[nextNode], nextNode))

                    if(nextNode == endNode-1) break@loop
                }
            }
        }
    }

    println(dist[endNode-1])
}