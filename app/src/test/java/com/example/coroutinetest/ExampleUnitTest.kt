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
    fun `0) no runtest success`() = runTest {
        assertTrue(true)
    }

    @Test
    fun `1) no runtest success`() {
        val viewModel =
            MyViewModel()

        viewModel.fetch()
    }

    @Test
    fun `2) runTest success`() = runTest {
        assertTrue(
            true
        )
    }
}