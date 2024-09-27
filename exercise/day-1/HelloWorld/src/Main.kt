fun main() {
    var fuelTank = 3
    while (fuelTank < 50){
        println("Fuel Tank: $fuelTank")
        fuelTank += 5
        if(fuelTank > 40) {
            println("Fuel Tank: $fuelTank")
            break
        }
    }
}