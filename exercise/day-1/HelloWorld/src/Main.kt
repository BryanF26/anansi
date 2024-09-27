fun main() {
    val spends = 200
    var finalPrice = when {
        spends > 200 -> spends * 0.7
        spends > 100 && spends <= 200 -> spends * 0.8
        spends > 50 && spends <= 100 -> spends * 0.9
        spends in 0..50 -> spends
        else -> "Spends mustn't negative"
    }
    println("Final Price: $finalPrice")
}