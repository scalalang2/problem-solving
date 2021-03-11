import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val (n, k) = sc.nextLine().split(" ").map { it.toInt() }
    var answer:Long = 0

    // q를 생성한다.
    var queue: MutableList<Queue<Int>> = mutableListOf()
    (0..20).forEach {
        queue.add(LinkedList<Int>())
    }
    
    // 1차 시도 : 메모리 초과
    // 실시간으로 처리하면서 계산해야 한다.
    (0 until n).forEach {
        val cls = sc.nextLine().length - 1
        val rank = it + 1

        if(queue[cls].isNotEmpty()) {
            val prevRank = queue[cls].peek()
            if(rank - prevRank <= k) {
                answer++
            } else {
                queue[cls].remove()
            }
        }
        queue[cls].add(rank)
    }

    println(answer)
}

