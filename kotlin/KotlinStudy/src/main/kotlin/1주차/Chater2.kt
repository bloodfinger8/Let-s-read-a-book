package `1주차`


fun max1(a: Int , b: Int) : Int {
    return if(a>b) a else b
}

//식이 본문인 함수 (반환 타입 생략가능->타입추론)
fun max2(a: Int , b: Int) = if(a>b) a else b






fun main() {
//    println("hello world")
    println(max1(1,2))
    println(max2(1,2))

}