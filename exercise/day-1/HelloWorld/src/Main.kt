fun main() {
    var scores = 90
    var grades = if(scores in 90..100) "A" else if (scores in 80..89) "B" else if (scores in 70..79) "C" else if (scores in 60..69) "D" else if(scores in 0..59) "F" else "Masukkan nilai range 0 sampai 100"
    println("Grades: " + grades)
}