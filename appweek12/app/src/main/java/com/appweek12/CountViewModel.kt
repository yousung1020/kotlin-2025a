package com.appweek12

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class CountViewModel : ViewModel(){
    private val _count = MutableStateFlow(0)

//    val count: LiveData<Int> = _count // 구형 방식
    // asStateFlow가 읽기 전용 변수로 만듦
    val count: StateFlow<Int> = _count.asStateFlow()

    fun increment(){
        _count.value += 1
    }

    fun decrement(){
        _count.value -= 1
    }

    fun reset(){
        _count.value = 0
    }

    fun incrementBy10(){
        _count.value = (_count.value) + 10
    }
}