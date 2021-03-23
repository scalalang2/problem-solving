import java.util.*

fun main() {
    val N = 200000
    val (c, b) = readLine()!!.split(" ").map { it.toInt() }
    val dp = Array<Int>(N + 2) { 0 }
    val dist:MutableList<Int> = mutableListOf()

    // 위치 정보 업데이트
    var curr = c
    var seconds = 1
    while(curr < N) {
        dist.add(curr)
        curr = curr + seconds
        seconds++
    }

    val queue:Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(b, 0))
    
    var ans = -1
    while(!queue.isEmpty()) {
        // pos: 현재위치, sec: 현재 시간
        val (pos, sec) = queue.remove()
        if(pos == dist[sec]) {
            ans = sec
            break
        }

        if(pos-1 >= c)
            queue.add(Pair(pos-1, sec+1))

        if(pos+1 < N)
            queue.add(Pair(pos+1, sec+1))

        if(pos*2 < N)
            queue.add(Pair(pos*2, sec+1))
    }

    println(ans)
}