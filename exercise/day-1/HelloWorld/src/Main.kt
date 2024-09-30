//fun main() {
//    var fuelTank = 3
//    while (fuelTank < 50){
//        println("Fuel Tank: $fuelTank")
//        fuelTank += 5
//        if(fuelTank > 40) {
//            println("Fuel Tank: $fuelTank")
//            break
//        }
//    }
//}

fun reserveSeat(name: String, seatNumber: Int, availableSeats:Array<Int>) {
    if (availableSeats.contains(seatNumber)) {
        availableSeats[seatNumber-1] = 0  // Mark the seat as reserved by setting it to 0
        println("$name reserved seat $seatNumber.")
    } else {
        println("Seat $seatNumber is already reserved.")
    }
}

fun main() {
    val availableSeats = arrayOf(1, 2, 3, 4, 5)
    reserveSeat("John", 2, availableSeats)
    reserveSeat("Sarah", 2, availableSeats)
}