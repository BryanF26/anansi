fun main() {
    val secretNum = 7
    val guessed = arrayOf(5,3,7,0)
    var i = 0
    do{
        println(guessed[i])
        if (secretNum.equals(guessed[i])) break
        i++
    } while (true)
}