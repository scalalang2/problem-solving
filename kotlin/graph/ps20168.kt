import java.util.*

// 5 5 1 3 10
// 1 2 5
// 2 3 5
// 1 4 1
// 4 5 6
// 5 3 1
/*
    돈 c로 갈 수 있는 모든 경로 중에서
    한 경로에서 내야되는 돈의 최대값을 구해야 한다.
*/
val MAX = Int.MAX_VALUE

data class Edge(val node: Int, val weight: Int)

var graph = MutableList<MutableList<Edge>>(11) { mutableListOf() }

fun dfs(curr: Int, to: Int, cap: Int, maxCap: Int, visited: BooleanArray): Pair<Int, Boolean> {
    if(visited[curr]) return Pair(MAX, false)
    if(curr == to) return Pair(maxCap, true)

    var _visited = visited.copyOf()
    _visited[curr] = true

    var answer = MAX
    var success = false
    for(el in graph[curr]) {
        val nextNode = el.node
        val weight = el.weight

        if(cap - weight >= 0) {
            val result = dfs(nextNode, to, cap - weight, Math.max(maxCap, weight), _visited)
            if(result.second) {
                answer = Math.min(result.first, answer)
                success = true
            }
        }
    }

    return Pair(answer, success)
}

fun main() {
    val sc = Scanner(System.`in`)
    val (n, m, a, b, c) = sc.nextLine().split(" ").map { it.toInt() }

    // 그래프 구성
    for (i in 0 until m) {
        val (from, to, cap) = sc.nextLine().split(" ").map { it.toInt() }
        graph[from].add(Edge(to, cap))
        graph[to].add(Edge(from, cap))
    }

    val visited = BooleanArray(11) { false }
    val result = dfs(a, b, c, 0, visited)
    if(result.second) {
        println(result.first)
    } else {
        println(-1)
    }
}