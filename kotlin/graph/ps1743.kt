import java.util.*

val dx = intArrayOf(1, 0, -1, 0)
val dy = intArrayOf(0, 1, 0, -1)

fun dfs(map: Array<IntArray>, visited: Array<IntArray>, x: Int, y: Int): Int {
    val n = map.size
    val m = map[0].size
    var ans = 1

    visited[y][x] = 1

    for(i in 0..3) {
        val nx = x + dx[i]
        val ny = y + dy[i]

        if(nx >= 0 && nx < m && ny >= 0 && ny < n && map[ny][nx] == 1 && visited[ny][nx] == 0) {
            ans += dfs(map, visited, nx, ny)
        }
    }

    return ans
}

fun main() {
    val (n,m,k) = readLine()!!.split(" ").map { it.toInt() }
    val map = Array(n) { IntArray(m) { 0 }}
    val visited = Array(n) { IntArray(m) { 0 }}
    var ans = 0

    (0 until k).forEach {
        val (r, c) = readLine()!!.split(" ").map { it.toInt() }
        map[r-1][c-1] = 1
    }

    for(i in 0 until n) {
        for(j in 0 until m) {
            if(map[i][j] == 1 && visited[i][j] == 0)
                ans = Math.max(ans, dfs(map, visited, j, i))
        }
    }

    println(ans)
}

