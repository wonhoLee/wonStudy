package main.s21

import main.s21.Color.*
import java.lang.Exception

class When {
    fun getWarmth(color:Color) = when(color){
        RED, ORANGE, YELLOW -> "warm"
    }

    fun mix(c1:Color, c2:Color) = when(setOf(c1, c2)){
        setOf(RED, YELLOW) -> ORANGE
        else -> throw Exception("Dirty color")
    }

    fun mixOptimized(c1:Color, c2: Color) = when{
        (c1 == RED && c2 == YELLOW) -> ORANGE
        else -> throw Exception("Dirty color")
    }
}

