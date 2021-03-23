import java.util.*

fun main() {
    val t = readLine()!!.toInt()
    (0 until t).forEach {
        val (n, p)  = readLine()!!.split(" ").map{ it.toInt() }
        val graph = Array<MutableList<Int>>(n + 1) { mutableListOf() }
        (0 until p).forEach {
            val (u, v) = readLine()!!.split(" ").map { it.toInt() }
            graph[u].add(v)
            graph[v].add(u)
        }

        var ans = 0
        val visited = BooleanArray(n + 1) { false }
        val stack = Stack<Int>()
        stack.push(1)
        visited[1] = true

        while(!stack.isEmpty()) {
            val curr = stack.pop()
            for(next in graph[curr]) {
                if(!visited[next]) {
                    visited[next] = true
                    stack.push(next)
                    ans++
                }
            }
        }

        println(ans)
    }
}