import java.util.*

fun main() {
    var scanner = Scanner(System.`in`)
    var N = scanner.nextInt()
    var M = scanner.nextInt()
    var arr: Array<Int> = Array(N + 1) { i -> i }
    for (i in 0 until M) {
        var start = scanner.nextInt()
        var end = scanner.nextInt()
        arr = reverse(arr, start, end)
    }
    for (i in 1..N) {
        print("${arr[i]} ")
    }

}

fun reverse(arr: Array<Int>, start: Int, end: Int): Array<Int> {
    var copy = arr.clone()
    var len = end - start
    for (i in 0..len) {
        copy[start + i] = arr[end - i]
    }
    return copy
}
