package com.kotlinbasics

import android.os.Bundle
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

        week02Variables()
        week02Functions()
    }
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