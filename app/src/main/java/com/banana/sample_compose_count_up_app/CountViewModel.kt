package com.banana.sample_compose_count_up_app

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class CountViewModel: ViewModel() {

    var currentCount = mutableStateOf(0)

    fun onClickCounter() {
        val currentValue = this.currentCount.value
        this.currentCount.value = currentValue + 1
    }
}