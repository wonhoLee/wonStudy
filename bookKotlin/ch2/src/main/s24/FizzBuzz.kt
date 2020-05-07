package main.s24

fun fizzBuzz(i:Int) = when {
    i % 15 == 0 -> "FizzBUzz"
    i % 3 == 0 -> "Fizz"
    i % 5 == 0 -> "Buzz"
    else -> "$i"
}