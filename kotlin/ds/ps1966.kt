import java.util.*

data class Item(val value:Int, val check: Boolean)

fun solve(n:Int, m:Int, list:IntArray):Int {
    val items = (0 until n).map {
        Item(list[it], it == m)
    }
    var answer = 0

    var q: Queue<Item> = LinkedList<Item>(items)
    while(q.isNotEmpty()) {
        val item = q.remove()
        val cnt = q.filter { it.value > item.value }.count()
        if(cnt > 0) {
            q.add(item)
        } else {
            answer++
        }
        if(cnt == 0 && item.check) break
    }
    
    return answer
}

fun main() {
    val sc = Scanner(System.`in`)
    val t = sc.nextLine().toInt()

    (0 until t).forEach {
        // n = 문서의 개수
        // m = m번째 문서
        val (n, m) = sc.nextLine().split(" ").map { it.toInt() }
        val lst = sc.nextLine().split(" ").map { it.toInt() }
        println(solve(n, m, lst.toIntArray()))
    }
}