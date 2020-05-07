package main.s23

interface Expr
class Num(val value: Int) : Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun eval(e: Expr): Int {
    if (e is Num) {
        val n = e as Num
        return n.value
    }
    if (e is Sum) {
        return eval(e.right) + eval(e.left)
    }
    throw IllegalArgumentException("Unknown Expressions")
}

fun eval2(e: Expr): Int {
    if (e is Num) {
        return e.value
    } else if (e is Sum) {
        return eval2(e.right) + eval2(e.left);
    } else {
        throw IllegalArgumentException("Unknown Expressions")
    }
}

fun eval3(e: Expr): Int {
    when (e) {
        is Num ->
            return e.value
        is Sum ->
            return eval3(e.right) + eval3(e.left);
        else ->
            throw IllegalArgumentException("Unknown Expressions")
    }
}

fun evalWithLogging(e: Expr): Int {
    when (e) {
        is Num -> {
            println("num: ${e.value}")
            return e.value
        }
        is Sum -> {
            val left = evalWithLogging(e.left)
            val right = evalWithLogging(e.right)
            println("sum: $left + $right")
            return left + right
        }
        else -> throw IllegalArgumentException("Unknown Expressions")
    }
}