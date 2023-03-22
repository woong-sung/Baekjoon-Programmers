import java.util.Scanner

fun main() {
    val sc: Scanner = Scanner(System.`in`)
    val grade = sc.nextInt()
    when {
        grade >= 90 -> println("A")
        grade >= 80 -> println("B")
        grade >= 70 -> println("C")
        grade >= 60 -> println("D")
        else -> println("F")
    }
}