package com.example.coroutinetest

import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

import org.junit.Assert.*
import org.junit.FixMethodOrder
import org.junit.Rule
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

    @Test
    fun `1) no runtest success`() {
        val viewModel =
            MyViewModel()

        val onNavigate: (MyNavigationEvent) -> Unit = mockk()

        viewModel.fetch(onNavigate)
        Thread.sleep(1000)
    }

    @Test
    fun `2) runTest success`() = runTest {
        Thread.sleep(1000)

        assertTrue(
            true
        )
    }

    @Test
    fun `3) failure with runtest`() = runTest {
        val viewModel =
            MyViewModel()

        val onNavigate: (MyNavigationEvent) -> Unit = mockk()

        viewModel.fetch(onNavigate)
        assertTrue(
            true
        )
    }
}