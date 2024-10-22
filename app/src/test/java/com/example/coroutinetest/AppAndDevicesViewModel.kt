package com.example.coroutinetest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.rules.TestWatcher
import org.junit.runner.Description

class MyViewModel : ViewModel() {
    fun fetch(onNavigate: (MyNavigationEvent) -> Unit) {
        viewModelScope.launch {
            onNavigate.invoke(
                MyNavigationEvent.ToScreen
            )
        }
    }
}

sealed class MyNavigationEvent {
    data object ToScreen :
        MyNavigationEvent()
}

class MainCoroutineRule(val dispatcher: TestDispatcher = StandardTestDispatcher()) :
    TestWatcher() {
    override fun starting(description: Description?) {
        super.starting(description)
        Dispatchers.setMain(dispatcher)
    }

    override fun finished(description: Description?) {
        super.finished(description)
        Dispatchers.resetMain()
    }
}
