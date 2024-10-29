package com.example.coroutinetest

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.TestDispatcher
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Test

import org.junit.Assert.*
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.rules.TestRule
import org.junit.rules.TestWatcher
import org.junit.runner.Description
import org.junit.runner.OrderWith
import org.junit.runners.MethodSorters

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
class ExampleUnitTest {
    @get:Rule
    val coroutineRule = MainCoroutineRule()

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun `1) no runtest success`() = runTest {
        assertTrue(true)
    }

    @Test
    fun `2) no runtest success`() {
        val viewModel =
            MyViewModel()

        viewModel.fetch()
    }

    @Test
    fun `3) runTest failure before starting`() = runTest {
        assertTrue(
            true
        )
    }
}

class MyViewModel : ViewModel() {
    fun fetch() {
        viewModelScope.launch {
            throw Exception("test")
        }
    }
}

class MainCoroutineRule(val dispatcher: TestDispatcher = UnconfinedTestDispatcher()) :
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