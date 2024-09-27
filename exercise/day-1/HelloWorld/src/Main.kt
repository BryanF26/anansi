fun main() {
    var scores = 80
    var grades = if(scores in 90..100) "A" else if (scores >= 80) "B" else if (scores >= 70) "C" else if (scores >= 60) "D" else if(scores in 0..59) "F" else "Masukkan nilai range 0 sampai 100"
    println("Grades: " + grades)
}