
# 4장 클래스 , 객체, 인터페이스

### 클래스와 인터페이스
코틀린 인터페이스는 자바8 인터페이스와 비슷하다 (디폴트 메소드)
다만 인터페이스에는 아무런 상태(필드)도 들어갈 수 없다.

```kotlin
//인터페이스 선언
interface Clickable {
    fun click()
}

//인터페이스 구현
class Button : Clickable {
    override fun click() = print("hi")
}
```
자바와 마찬가지로 클래스는 인터페이스를 원하는 만큼 개수 제한 없이 마음대로 구현할 수 있지만
, 클래스는 오직 하나만 확장할 수 있다.
자바의 @Override 애노테이션과 비슷한 override 변경자는 상위 클래스나 상위인터페이스에 있는 프로퍼티나
메소드를 오버라이드한다는 표시다. 하지만 자바와 달리 코틀린에서는 override 변경자는 꼭 사용해야 한다.

```kotlin
//인터페이스 선언
interface Clickable {
    fun click()
    fun showOff() = print("디폴트 메소드이다.")
}
```
자바8과 달리 특별한 키워드를 쓸 필요 없이 본문으로 그냥 시작하면 된다.

위와 같은 인터페이스에 동일한 매소드를 구현했을때 한 클래스에서 인터페이스를 함께 구현하면 어떻게 될까?
결과는 어느쪽도 선택하지 않으며 다음과 같은 컴파일 오류가 발생한다.

![dd](../image/4.5.png)
코틀린 컴파일러는 두 매소드를 아우르는 구현을 하위 클래스에 직접 구현하게 강제한다.

```kotlin
class Button : Clickable , Focusable {
    override fun click () = print("hi")
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusasble>.showOff()
    }
}
```



### 뻔하지 않은 생성자와 프로퍼티
### 데이터 클래스 
### 클래스 위임
### object 키워드 사용

