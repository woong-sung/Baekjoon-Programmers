import java.util.*

fun main(){
    var sc: Scanner = Scanner(System.`in`)
    var s = sc.nextLine()
    var l = s.length
    var ans: Int = 1
    for (i in 0..l/2){
        if (s[i] != s[l - i - 1]) {
            ans = 0
            break
        }
    }
    println(ans)
}