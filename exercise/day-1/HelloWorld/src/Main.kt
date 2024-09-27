fun main() {
    val years = 3
    val salary = 8000000
    var bonus = when {
        years > 5 -> salary * 0.2
        years in 2..5 -> salary * 0.1
        years in 0..2 -> 0
        else -> "Years mustn't negative"
    }
    println("Bonus: " + bonus)
}