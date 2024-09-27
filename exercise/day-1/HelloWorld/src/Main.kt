fun main() {
    val units = 250
    var totalElecBill = when {
        units > 200 -> 250 + (units-200) * 2
        units in 101..200 -> 100 + (units-100) * 1.5
        units in 0..100 -> units
        else -> "Units mustn't negative"
    }
    println("Final Price: $$totalElecBill")
}