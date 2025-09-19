package com.kotlinbasics

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.kotlinbasics.ui.theme.KotlinBasicsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            KotlinBasicsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }

//        week02Variables()
//        week02Functions()

        week03Classes()
//        week03Collections()
    }
}

private fun week03Collections(){
    println("== Kotlin Collections ==")

    val fruits = listOf("apple", "banana", "orange")
    val mutableFruits = mutableListOf("Kiwi", "Mango")

    // 불변 컬렉션이기 때문에 리스트 수정 불가능 ㅠㅠ
    // fruits.add("kiwi")
    println("Fruits: $fruits")

    // mutable 리스트라서 add로써 리스트 수정 가능!
    mutableFruits.add("banana")
    println("Mutable Fruits: $mutableFruits")

    // "Kim"이 key, to 옆에 100이 value
    val scores = mapOf("Kim" to 100, "Park" to 97, "Lee" to 99)
    println("Scores: $scores")

    // for each문 사용 가능! (iterable)
    for(fruit in fruits){
        println("I like $fruit")
    }

    // 가변 리스트도 당연히 가능
    for(fruit in mutableFruits){
        println("I like $fruit")
    }

    // map의 컬렉션 내부에 forEach 사용가능, 주의사항으로는 소괄호가 아닌 중괄호로 사용해야 함
    // 람다 형식으로 사용
    // 첫번째 인수에 key, 두번째 인수에 value
    scores.forEach{(name, score) -> println("$name scored $score")}
}

private fun week03Classes() {
//    println("== Kotlin Classes ==")
    Log.d("KotlinWeek03", "== Kotlin Classes ==")

    class Person(val name: String, var age: Int){
        fun Introduce(){
            Log.d("KotlinWeek03", "안녕하세요, $name ($age)세 입니다")
        }

        fun birthDay(){
            // 후위 연산자 사용 가능
            age++

            Log.d("KotlinWeek03", "$name 님의 생일! 이제 $age 세")
        }
    }

    val person1 = Person("최유성", 27)

    person1.Introduce();
    person1.birthDay()

    class Animal(var species: String){
        var weight: Double = 0.0

        constructor(species: String, weight: Double): this(species){
            this.weight = weight
            Log.d("KotlinWeek03", "$species 의 무게는 $weight kg 입니다")
        }

        fun makeSound(){
            Log.d("KotlinWeek03", "$species 가 소리를 냅니다")
        }
    }

    var puppy = Animal("웰시코기", 10.5)

    puppy.makeSound()

//    class Student{
//        var name: String = ""
//        var age: Int = 0
//
//        fun introduce(){
//            println("Hi, I'm $name and I'm $age years old")
//        }
//    }
//
//    val student = Student()
//    student.name = "Choi"
//    student.age = 23
//    student.introduce()
//
//    data class Person(val name: String, val age: Int)
//
//    val person1 = Person("Kim", 23)
//    val person2 = Person("Kim", 23)
//
//    println("Person1: $person1")
//    println("Equal? ${person1 == person2}")
}

private fun week02Functions(){
//    println("Week 02: Functions")
//    fun greet(name: String) = "Hello, $name!"
//
//    println(greet("Android developer"))

    println("== Kotlin Functions ==")

    fun greet(name: String): String{
        return "Hello, $name!"
    }

    fun add(a: Int, b: Int) = a + b

    fun introduce(name: String, age: Int = 19){
        println("My name is $name and im $age years old")
    }

    println(greet("kotlin"))
    println("sum = ${add(6, -71)}")
    introduce("CHoi", 23)
    introduce("CHoi")
}

private fun week02Variables(){
//    println("Week 02: Variables")
//
//    val courseName = "Moblie Programming"
//    // courseName = "skrr"
//    var week = 2
//    week = 3
//    println("Course: $courseName")
//    println("Week: $week")

    println("== Kotlin Variables ==")

    // val(immutable 불변), var(mutable 가변)
    val name = "Android"
    var version = 8

    println("Hello $name $version")

    // 타입 명시
    val age: Int = 23
    val height: Double = 178.0
    val isStudent: Boolean = true

    println("Age: $age, Height: $height, student: $isStudent")

    // null 비허용 -> 컴파일 시점에서 예외 발생
    // var nickname: String = null

    // null 허용
    var nickname: String? = null
    nickname = "mirae"
    println("nickname: $nickname ${nickname?.length}")
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    KotlinBasicsTheme {
        Greeting("Android")
    }
}