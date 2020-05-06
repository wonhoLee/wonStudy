package main.s21

import kotlin.random.Random

class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
    get(){
        return height == width
    }
}

fun createRandomRectangle() : Rectangle{
    val random = Random
    return Rectangle(random.nextInt(), random.nextInt())
}