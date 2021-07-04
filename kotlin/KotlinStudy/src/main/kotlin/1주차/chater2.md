#2.1 기본요소
## 2.1.2 함수
![함수](./resources/image/2.1.1.png)

코틀린의 문과 식의 구분 <br>
`코틀린에서는 if는 식이다, 문이 아니다
식 : 값을 만들어 내며 다른 식의 하위 요소로 계산에 참여할 수 있는 반면 문은 자신을 둘러 싸고
있는 가장 안쪽 블록의 최상위 요소로 존재하며 아무런 값을 만들어내지 않는다는 차이점이 있다.
자바에서는 모든 제어 구조가 문인 반면 코틀린에서는 루프를 제외한 대부분의 제어 구조가 식이다.
`

코틀린에서는 식이 본문인 함수가 자주 쓰인다.

---
##2.1.3 변수

- **val** : 변경 불가능한(immutable)참조를 저장하는 변수.
  선언된 변수는 일단 초기화하고 나면 재대입이 불가능하다.
  자바로 말하면 final 변수에 해당한다.
  

- **var** : 변경 가능한(mutable)참조다. 
    이런 변수의 값은 바뀔 수 있다.
    자바의 일반 변수에 해당한다.

---
val 참조 자체는 불변일지라도 그 팜조가 가리키는 객체의 내부 값은 변경될 수 있다는 사실을 기억해라
```kotlin
val languages = arrayListOf("java") //불변 참조를 선언
language.add("kotlin") // 참조가 가르키는 객체 내부를 변경한다.
```
---
var 키워드를 사용하면 변수의 값을 변경할 수 있지만 변수의 타입은 고정돼 바뀌지 않는다.
```kotlin
var answer = 24 
answer = "no answer" //type mismatch 컴파일 에러
```
어떤 타입의 변수에 다른 타입의 값을 저장하고 싶다면 변환 함수를 싸사 값을 변수의 타입으로 변환
하거나 값을 변수에 대입할 수 있는 타입으로 강제 형 변환해야 한다.
---

##2.1.4 더 쉽게 문자열 형식 지정 : 문자열 템플릿

코틀린에서도 변수를 문자열 안에 사용할 수 있다.
```kotlin
val name = "재우"
println("hello , $name ")
println("hello , ${name}님 ")
//$에 한글을 붙여서 사용하면 코틀린 컴파일러는 영문자와 한글을 한꺼번에 식별자로 인식해
//unresolved reference 오류를 발생시킨다.
//고로 중괄호로 변수명을 감싸는 습관을 들이면 좋다
```
---

# 2.2 클래스와 프로퍼티


```java
//java로 구현한 Person 클래스
public class Person {
    private final String name;
    
    public Person(String name) {
        this.name = name;
    }
    
    public String getName(){
        return name;
    }
}
```


```kotlin
//kotlin으로 구현한 Person 클래스
class Person(val name : String)
```

9줄이 1줄로 바뀌는 마법이 생긴다.

## 프로퍼티

자바에서는 `필드+접근자 = 프로퍼티` 부른다
코틀린 프로퍼티는 자바의 필드와 접근자 메소드를 완전히 대신한다.

val 선언시 -> 읽기전용<br>
var 선언시 -> 변경가능

```kotlin
class Person {
    val name : String,
    var isMarried : Boolean        
}

val person = Person("jaewoo" , true)
println(person.name) //이름을 직접사용해도 자동으로 getter 호출
```

##2.2.2 커스텀 접근자

```kotlin
class Rectangle(val height: Int , val width: Int) {
    val isSqaure : Boolean
        get() = height == width 
}
```

##2.2.3 디렉터리와 패키지

패키지 이름 뒤에 .* 사용시 패키지 안의 모든 선언을 임포트할 수 있다.
그런데 패키지 안에 있는 모든 클래스뿐 아니라 최상위에 정의된 함수나 프로퍼티까지
모두 불러온다는 점에 유의 해야한다.

코틀린에서는 여러 클래스를 한 파일에 넣을 수 있고, 파일의 이름도 마음대로 정할 수 있다.
디스크상의 어느 디렉터리에 소스코드 파일을 위치시키든 관계 없다.
따라서 원하는 대로 소스코드를 구성할 수 있다.

But, 대부분의 경우 자바와 같이 패키지별로 디렉터리를 구성하는 편이 낫다.
특히 자바와 코틀린을 함께 사용하는 프로젝트에서는 자바의 방식을 따르는게 중요하다.

#2.3 선택 표현과 처리 : enum 과 when

##2.3.1 enum
enum은 자바 ㅏ선언보다 코틀린 선언에 더 많은 키워드를 써야 하는 흔치 않은 예다.

```kotlin
enum class Color(val r : Int , val g: Int, val b : Int) {
    RED(255,0,0),
    ORANGE(255,165,0),
    YELLOW(255,255,0),
    GREEN(0,255,0),
    BLUE(0,0,255),
    INDIGO(75,0,130),
    VLOLET(238,130,238);
    
    fun rgb() = (r * 256 + g) * 256 + b
}

fun main(){
    println(Color.BLUE.rgb())
 }
```


when 도 if와 마찬가지로 값을 만들어 낸다.
고로 식이 본문인 함수에 when을 바로 사용할 수 있다.
```kotlin
fun getWarmth(color : Color) = when(color) {
    Color.RED,Color.ORANGE,Color.YELLOW -> "warm"
    Color.GREEN -> "netuarl"
    color.BLUE,color.INDIGO,color.VLOLET -> "cold"
}

fun main() {
    println(getWarmth(Color.ORANGE))
}
```

아래와 같이 여러 다른 객체를 사용할 수 있다.
```kotlin
fun mix(c1 : Color , c2 : Color) = 
    when(setOf(c1,c2)) {
        setOf(RED,ORANGE -> "warm"
        setOf(YELLOW,GREEN) -> "netuarl"
        setOf(BLUE,INDIGO) -> "cold"
        else -> throw Exception("Dirty color")
}

fun main() {
    println(mix(BLUE,YELLOW))
}





