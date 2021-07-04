package `1주차`

class Rectangle(val height: Int , val width: Int) {
    val isSqaure : Boolean
        get() = height == width
}


fun main() {
    val rectangle = Rectangle(4,4)
    println(rectangle.isSqaure)
}