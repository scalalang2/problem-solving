import java.util.*

val SELF_EDGE = 401
val graph = Array<MutableList<Int>>(802) { mutableListOf() }
val cap = Array(802) { Array<Int>(802) { 0 } }
val flow = Array(802) { Array<Int>(802) { 0 } }

fun main() {
    val (n,p) = readLine()!!.split(" ").map { it.toInt() }

    (0 until p).forEach {
        val (u,v) = readLine()!!.split(" ").map {it.toInt()}
        val u_prime = u + SELF_EDGE
        val v_prime = v + SELF_EDGE
        // self edge 추가
        // u -> u' -> v -> v'
        graph[u_prime].add(v)
        graph[v].add(u_prime)
        graph[v_prime].add(u)
        graph[u].add(v_prime)

        cap[u_prime][v] = Int.MAX_VALUE
        cap[v_prime][u] = Int.MAX_VALUE
    }

    (1..n).forEach {
        graph[it].add(it + SELF_EDGE)
        graph[it + SELF_EDGE].add(it)
        cap[it][it + SELF_EDGE] = 1
    }

    cap[1 + SELF_EDGE][2] = Int.MAX_VALUE
    cap[2 + SELF_EDGE][1] = Int.MAX_VALUE

    // (0 until p).forEach {
    //     // 그래프의 값을 초기화 한다.
    //     val (u, v) = readLine()!!.split(" ").map { it.toInt() }
    //     graph[u].add(v)
    //     graph[v].add(u)
    //     cap[u][v] = 1
    //     cap[v][u] = 0
    // }

    val S = 1
    val E = 2 // S=시작, E=도착 지점
    var totalFlow = 0 // 총 유량

    while(true) {
        val queue: Queue<Int> = LinkedList<Int>()
        val path = IntArray(802) { -1 }
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