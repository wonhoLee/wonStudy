package main.s211

enum class Color (
        val r: Int, val g: Int, val b: Int
){
    RED(255,0,0), ORANGE(255,165,0),
    YELLOW(255,255,0);
    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) =
        when(color){
            Color.RED -> "Richard"
            Color.ORANGE -> "Of"
            Color.YELLOW -> "test"
        }

fun getWarmth(color:Color) =
        when(color){
            Color.RED, Color.ORANGE -> "warm"
            Color.YELLOW -> "test"
        }