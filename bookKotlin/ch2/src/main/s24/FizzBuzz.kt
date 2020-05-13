package main.s24

import java.io.BufferedReader

fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBUzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}

fun readNumber(reader: BufferedReader): Int? {
    return try {
        val line = reader.readLine()
        Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        null
    } finally {
        reader.close()
    }
}