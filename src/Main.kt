import kotlin.math.*
fun main() {
    println("Завдання №2")

    var a: Double
    var b: Double
    var c: Double
    var d: Double

    do {
        print("Введіть значення a: ")
        a = readln().toDouble()
        print("Введіть значення b: ")
        b = readln().toDouble()
    } while (a >= b)

    do {
        print("Введіть значення c: ")
        c = readln().toDouble()
        print("Введіть значення d: ")
        d = readln().toDouble()
    } while (c >= d)

    val xAxis = DoubleArray(8)
    val yAxis = DoubleArray(8)

    val xStep = (b - a) / (9)
    val yStep = (d - c) / (9)

    for (i in 0..7) {
        xAxis[i] = a + (i + 1) * xStep
        yAxis[i] = c + (i + 1) * yStep
    }

    val result = Array(8) { DoubleArray(8) }

    for (i in 0..7) {
        for (j in 0..7) {
            result[i][j] = 7 * log10(xAxis[j] + yAxis[7 - i])
        }
    }

    val table = Array(9) { DoubleArray(9) }

    for (i in 0..8) {
        for (j in 0..8) {
            if (j == 0 && i == 8) table[i][j] = 0.0
            else if (j == 0) table[i][j] = yAxis[7 - i]
            else if (i == 8) table[i][j] = xAxis[j - 1]
            else table[i][j] = result[i][j - 1]
        }
    }

    var formattedNumber: String

    for (i in 0..8) {
        for (j in 0..8) {
            formattedNumber = String.format("%.2f", table[i][j])
            System.out.printf("$formattedNumber ")
            if (j == 0) print("| ")
        }
        println()
        if (i == 7) println("-----+----------------------------------------")
    }
}
