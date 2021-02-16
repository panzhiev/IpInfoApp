package com.panzhiev.ui

import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class IpValidatorTest(
    private val arguments: TestArguments
) {

    @Test
    fun `given ip when data is validated then return the correct result`() {
        // Given
        val data = arguments.ip

        // When
        val result = data.isIpValid()

        // Then
        assertEquals(arguments.expected, result)
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun parameters() =
            listOf(
                TestArguments(null, false),
                TestArguments("", false),
                TestArguments("text", false),
                TestArguments("1", false),
                TestArguments("1.1", false),
                TestArguments("1.1.1", false),
                TestArguments("1.1.1.1111", false),
                TestArguments("11.11.11.11", true)
            )
    }

    data class TestArguments(
        val ip: CharSequence?,
        val expected: Boolean
    )
}
