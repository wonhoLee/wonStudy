package main.s211

fun main() {
    study5()
}

fun study(): Unit {
    val question = "테스트"
    val answer = 42
    val answer2: Int = 42

    println(question)
    println(answer)
    println(answer2)
}

fun study2(): Unit {
    val a = 42
//    a = 43

    var b = 42
    b = 43

    println(a)
    println(b)
}

fun study3(): Unit{
    val name = "kotlin"
    println("Hello, ${name}!")

    println("안녕, ${name}!")
}

fun study4(): Unit {
    val person = Person("Bob", true)
    println(person.name)
    println(person.isMarried)
}

fun study5(){
    println(createRandomRectangle().isSquare)
    println(getMnemonic(Color.RED))
}
