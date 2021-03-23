import java.util.*

val dx = arrayOf(2, -2, 2, -2, 1, -1, 1, -1)
val dy = arrayOf(1, 1, -1, -1, 2, 2, -2, -2)

fun main() {
    val t = readLine()!!.toInt()
    (0 until t).forEach {
        val n = readLine()!!.toInt()
        
        // nxn 체스판
        val board = Array<Array<Int>>(n) { Array(n) { 0 } }
        val (start_row, start_col) = readLine()!!.split(" ").map { it.toInt() }
        val (end_row, end_col) = readLine()!!.split(" ").map { it.toInt() }

        val queue:Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(start_row, start_col))
        board[start_row][start_col] = 1

        while(!queue.isEmpty()) {
            val curr = queue.remove()
            for(i in 0 until 8) {
                val ny = curr.first + dy[i]
                val nx = curr.second + dx[i]
                if(ny >= 0 && ny < n && nx >= 0 && nx < n && board[ny][nx] == 0) {
                    board[ny][nx] = board[curr.first][curr.second] + 1
                    queue.add(Pair(ny, nx))
                }
            }
        }

        println(board[end_row][end_col] - 1)
    }
}